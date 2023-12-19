package picpay.Picpaychallenge.services.interfaces

import picpay.Picpaychallenge.domain.User.User

interface UserService {

    fun retrieveUser(document: String): User
}
