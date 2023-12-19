package picpay.Picpaychallenge.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.domain.User.User
import picpay.Picpaychallenge.repository.UserRepository
import picpay.Picpaychallenge.services.interfaces.UserService

@Component
class UserServiceImpl(
    val userRepository: UserRepository
): UserService {

    companion object{
        val logger = LoggerFactory.getLogger(javaClass)
    }

}