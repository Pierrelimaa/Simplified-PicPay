package picpay.Picpaychallenge.repository

import org.springframework.stereotype.Component
import picpay.Picpaychallenge.repository.interfaces.UserRepository

@Component
class UserRepositoryImpl(): UserRepository {
    override fun retrieveUser(document: String) {
        return
    }
}