package picpay.Picpaychallenge.repository

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import picpay.Picpaychallenge.repository.entities.AccountEntity
import java.math.BigDecimal
import java.util.*

interface BalanceRepository : JpaRepository<AccountEntity, Long> {

    fun getBalanceByDocument(document: String): AccountEntity?

    @Modifying
    @Transactional
    @Query("UPDATE AccountEntity SET balance = :newBalance WHERE document = :document")
    fun updateBalance(@Param("newBalance") balance: BigDecimal, @Param("document") document: String)

    fun save(newUser: AccountEntity): Optional<AccountEntity>
}