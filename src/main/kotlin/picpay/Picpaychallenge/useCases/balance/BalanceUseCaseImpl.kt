package picpay.Picpaychallenge.useCases.balance


import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.domain.Account
import picpay.Picpaychallenge.domain.Exception.IncorrectPasswordException
import picpay.Picpaychallenge.services.interfaces.BalanceService
import picpay.Picpaychallenge.services.interfaces.UserService

@Component
class BalanceUseCaseImpl(
    val balanceService: BalanceService,
    val userService: UserService,

    ) {
    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    operator fun invoke(document: String, password: String): Account {
        logger.info("Retrieving document: $document data")


        val user = userService.retrieveUser(document)
        logger.debug("User ${user.invoke()}")

        val userBalance = if (user.isPasswordCorrect(password)) {
            balanceService.getBalance(user.document)

        } else {
            logger.error("Incorrect password")
            throw IncorrectPasswordException("Password is not correct")
        }

        return Account(user, userBalance.amount)
    }
}
