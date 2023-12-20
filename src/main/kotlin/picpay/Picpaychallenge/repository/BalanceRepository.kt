package picpay.Picpaychallenge.repository

import org.springframework.data.jpa.repository.JpaRepository
import picpay.Picpaychallenge.repository.entities.AccountEntity
import java.util.*

interface BalanceRepository: JpaRepository<AccountEntity, Long>{

    fun getBalanceByDocument(document: String): AccountEntity?

    fun save(newUser: AccountEntity): Optional<AccountEntity>
}