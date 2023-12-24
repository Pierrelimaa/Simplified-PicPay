package picpay.Picpaychallenge.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.repository.TransactionRepository
import picpay.Picpaychallenge.repository.entities.TransactionEntity
import picpay.Picpaychallenge.services.interfaces.TransactionService
import picpay.Picpaychallenge.services.interfaces.dtos.TransactionDto

@Component
class TransactionServiceImpl(
    private val transactionRepository : TransactionRepository
) : TransactionService {

    companion object{
        val logger = LoggerFactory.getLogger(javaClass)
    }
    override fun persistTransaction(persistTransactionInput: TransactionDto) {

        logger.info("Persisting transaction")
        val transaction = TransactionEntity(
            transactionId = null,
            senderDocument = persistTransactionInput.senderDocument,
            receiverDocument = persistTransactionInput.receiverDocument,
            amount = persistTransactionInput.transferedAmount
        )

        transactionRepository.save(transaction = transaction)
    }
}