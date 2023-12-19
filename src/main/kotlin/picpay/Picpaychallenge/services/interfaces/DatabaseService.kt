package picpay.Picpaychallenge.services.interfaces

import picpay.Picpaychallenge.domain.User.User
import picpay.Picpaychallenge.useCases.balance.BalanceResponse

interface DatabaseService {

    fun retrieveUser(document: String): User

    fun getBalance(document: String): BalanceResponse

}