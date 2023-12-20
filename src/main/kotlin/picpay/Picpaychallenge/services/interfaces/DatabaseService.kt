package picpay.Picpaychallenge.services.interfaces

import picpay.Picpaychallenge.domain.User.User
import picpay.Picpaychallenge.repository.entities.UserEntity
import picpay.Picpaychallenge.useCases.balance.BalanceResponse
import java.util.*

interface DatabaseService {

    fun retrieveUser(document: String): User

    fun getBalance(document: String): BalanceResponse

    fun insertUser(payload: User): Optional<UserEntity>

}