package picpay.Picpaychallenge.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.repository.UserRepository
import picpay.Picpaychallenge.services.interfaces.AccountService

@Component
class AccountServiceImpl(
    val userRepository: UserRepository
): AccountService {

    companion object{
        val logger = LoggerFactory.getLogger(javaClass)
    }

}