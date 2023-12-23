package picpay.Picpaychallenge.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.domain.Account
import picpay.Picpaychallenge.repository.BalanceRepository
import picpay.Picpaychallenge.repository.UserRepository
import picpay.Picpaychallenge.services.interfaces.AccountService
import picpay.Picpaychallenge.services.interfaces.dtos.TransferDTO

@Component
class AccountServiceImpl(
    val balanceRepository: BalanceRepository
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

// Realizar transferencia
        logger.info("Making transaction from ${senderAccount.userDocument} to ${receiverAccount.userDocument}")
        makeTransfer(senderAccount, transferInput, receiverAccount)

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