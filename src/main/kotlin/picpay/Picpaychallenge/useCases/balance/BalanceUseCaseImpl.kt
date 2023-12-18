package picpay.Picpaychallenge.useCases.balance


import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.domain.User.isValidDocument
import picpay.Picpaychallenge.repository.interfaces.BalanceRepository
import picpay.Picpaychallenge.repository.interfaces.UserRepository
import java.math.BigDecimal

@Component
class BalanceUseCaseImpl(
    val balanceRepository: BalanceRepository,
    val userRepository: UserRepository

) {
    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    operator fun invoke(document: String, password: String): BalanceResponse? {
        logger.info("Retrieving balance for $document")
        if (!document.isValidDocument()) {
            logger.error("Document isn't valid")
            return null
        }

        val customer = userRepository.retrieveUser(document)


        return BalanceResponse(BigDecimal(5000))

    }


}
