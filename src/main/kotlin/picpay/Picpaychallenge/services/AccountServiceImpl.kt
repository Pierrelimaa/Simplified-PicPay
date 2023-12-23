package picpay.Picpaychallenge.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.domain.Account
import picpay.Picpaychallenge.repository.BalanceRepository
import picpay.Picpaychallenge.services.client.Authorizer.AuthorizerClient
import picpay.Picpaychallenge.services.client.Notification.NotificationClient
import picpay.Picpaychallenge.services.interfaces.AccountService
import picpay.Picpaychallenge.services.interfaces.dtos.TransferDTO

@Component
class AccountServiceImpl(
    val balanceRepository: BalanceRepository,
    val authorizerClient: AuthorizerClient,
    val notificationClient: NotificationClient
): AccountService {

    companion object{
        val logger = LoggerFactory.getLogger(javaClass)
    }

    override fun transfer(transferInput: TransferDTO) {
// Validar se o cliente tem saldo
       logger.info("Validating if user has the amount to transfer")
       val senderAccount = transferInput.senderAccount

        if (!senderAccount.hasAmountToTrasfer(transferInput.amountToTransfer)){
            logger.error("User ${senderAccount.userDocument} doesn't has enough money to make this transfer")
            return
        }

// Buscar conta do destinatario
        logger.info("Recovery balance of receiver")
        val receiverAccount = balanceRepository.getBalanceByDocument(transferInput.receiverDocument)?.toAccount() ?: return

// Consulta serviço de autorização externo
        val authorizerTransaction =  authorizerClient.authorizeTransaction()
        logger.info("Autohorizer service resonse: $authorizerTransaction")
        if (authorizerTransaction.message.isNullOrBlank()) {
            logger.error("Transaction not allowed by authorizer, try again in a few minutes")
            return
        }

// Realizar transferencia
        logger.info("Making transaction from ${senderAccount.userDocument} to ${receiverAccount.userDocument}")
        makeTransfer(senderAccount, transferInput, receiverAccount)

// Notifica cliente
        logger.info("Notify client ${receiverAccount.userDocument}")
        notificationClient.noitifyClient(receiverAccount.userDocument)
    }

    private fun makeTransfer(
        senderAccount: Account,
        transferInput: TransferDTO,
        receiverAccount: Account,
    ) {
        val currentSenderAccount = senderAccount.subtractAmount(takenAmount = transferInput.amountToTransfer)
        balanceRepository.updateBalance(currentSenderAccount.amount, currentSenderAccount.userDocument)
        val currentReceiverAccount = receiverAccount.addAmount(transferAmount = transferInput.amountToTransfer)
        balanceRepository.updateBalance(currentReceiverAccount.amount, currentReceiverAccount.userDocument)
    }


}