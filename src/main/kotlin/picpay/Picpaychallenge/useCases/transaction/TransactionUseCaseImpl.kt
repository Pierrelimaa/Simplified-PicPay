package picpay.Picpaychallenge.useCases.transaction

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.services.interfaces.AccountService
import picpay.Picpaychallenge.services.interfaces.DatabaseService
import picpay.Picpaychallenge.services.interfaces.dtos.TransferDTO
import picpay.Picpaychallenge.useCases.balance.BalanceUseCaseImpl

@Component
class TransactionUseCaseImpl(
    val databaseService: DatabaseService,
    val accountService: AccountService,
    val balanceUseCase: BalanceUseCaseImpl
) {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    operator fun invoke(transactionInput: TransactionInput) {

        logger.info("Making transaction from ${transactionInput.senderDocument} to ${transactionInput.receiverDocument}")

        val senderAccount = balanceUseCase.invoke(document = transactionInput.senderDocument, transactionInput.senderPassword)

        val transferInput = TransferDTO(
            senderAccount = senderAccount, receiverDocument = transactionInput.receiverDocument, amountToTransfer = transactionInput.transactionAmount
        )
        accountService.transfer(transferInput = transferInput)


    }
}
