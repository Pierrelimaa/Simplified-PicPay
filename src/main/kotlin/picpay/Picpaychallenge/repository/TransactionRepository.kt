package picpay.Picpaychallenge.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import picpay.Picpaychallenge.repository.entities.TransactionEntity

@Repository
interface TransactionRepository: JpaRepository<TransactionEntity, Long> {



    fun save(transaction: TransactionEntity)
}