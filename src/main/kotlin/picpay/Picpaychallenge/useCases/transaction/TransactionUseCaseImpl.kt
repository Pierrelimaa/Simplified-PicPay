package picpay.Picpaychallenge.useCases.transaction

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.domain.Enum.UserTypeEnum
import picpay.Picpaychallenge.domain.User.User
import picpay.Picpaychallenge.services.interfaces.AccountService
import picpay.Picpaychallenge.services.interfaces.DatabaseService
import picpay.Picpaychallenge.services.interfaces.dtos.TransferDTO
import picpay.Picpaychallenge.useCases.balance.BalanceUseCaseImpl

@Component
class TransactionUseCaseImpl(
    val databaseService: DatabaseService,
    val accountService: AccountService,
    val balanceUseCase: BalanceUseCaseImpl,
) {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    operator fun invoke(transactionInput: TransactionInput) {

        logger.info("Making transaction from ${transactionInput.senderDocument} to ${transactionInput.receiverDocument}")

        val senderUser = databaseService.retrieveUser(transactionInput.senderDocument).invoke()
//        Valida se o usuário é um lojista
        if (senderUser?.isMerchant() == true) {
            logger.warn("The user cannot transfer because merchant user can only receive transfer")
            return
        }

        val senderAccount =
            balanceUseCase.invoke(document = transactionInput.senderDocument, transactionInput.senderPassword)

        val transferInput = TransferDTO(
            senderAccount = senderAccount,
            receiverDocument = transactionInput.receiverDocument,
            amountToTransfer = transactionInput.transactionAmount
        )
        accountService.transfer(transferInput = transferInput)


    }




}
