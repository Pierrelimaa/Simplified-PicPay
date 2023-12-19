package picpay.Picpaychallenge.repository

import org.springframework.data.jpa.repository.JpaRepository
import picpay.Picpaychallenge.repository.entities.AccountEntity

interface BalanceRepository: JpaRepository<AccountEntity, Long>{

    fun getBalanceByDocument(document: String): AccountEntity?
}