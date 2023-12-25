package picpay.Picpaychallenge.useCases.balance


import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.domain.Account
import picpay.Picpaychallenge.domain.Exception.IncorrectPasswordException
import picpay.Picpaychallenge.services.interfaces.DatabaseService

@Component
class BalanceUseCaseImpl(
    val databaseService: DatabaseService

    ) {
    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    operator fun invoke(document: String, password: String): Account {
        logger.info("Retrieving document: $document")


        val user = databaseService.retrieveUser(document)
        logger.info("User ${user.invoke()}")

        val userBalance = if (user.isPasswordCorrect(password)) {
            databaseService.getBalance(user.document).also {
            logger.info("Balance found ")}
        } else {
            logger.error("Incorrect password")
            throw IncorrectPasswordException(message = "Password is not correct")
        }

        return Account(user.document, userBalance.amount)
    }
}
