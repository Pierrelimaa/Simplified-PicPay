package picpay.Picpaychallenge.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.domain.User.User
import picpay.Picpaychallenge.repository.BalanceRepository
import picpay.Picpaychallenge.repository.UserRepository
import picpay.Picpaychallenge.repository.entities.AccountEntity
import picpay.Picpaychallenge.repository.entities.UserEntity
import picpay.Picpaychallenge.services.interfaces.DatabaseService
import picpay.Picpaychallenge.useCases.balance.BalanceResponse
import java.math.BigDecimal
import java.util.*

@Component
class DatabaseServiceImpl(
    private val balanceRepository: BalanceRepository,
    private val userRepository: UserRepository
) : DatabaseService {

    companion object {
        val logger = LoggerFactory.getLogger(javaClass)
    }

    override fun retrieveUser(document: String): User {

        val customer = try {
            userRepository.findByDocument(document)
        } catch (ex: Exception) {
            logger.error("User not found")
            throw Exception("User not found")
        }

        return User(
            name = customer.name,
            document = customer.document,
            email = customer.email,
            password = customer.password
        )

    }


    override fun getBalance(document: String): BalanceResponse {
        val accountBalance = balanceRepository.getBalanceByDocument(document)

        return if (accountBalance != null) {
            BalanceResponse(accountBalance.balance)
        } else {
            throw Exception("Balance not found for document $document")
        }
    }

    override fun insertUser(payload: User): Optional<UserEntity> {

        val query =  try{
            logger.info("Inserting user: ${payload.document} into database if not exists")
            userRepository.save(payload.toUserEntity())
        }
        catch (ex: Exception){
            logger.error("Error while saving user: ${payload.document} into database | ex: ${ex.cause}")
            return Optional.empty()
        }
        logger.info("Creating account for user: ${payload.document} to database if not exists")
        balanceRepository.save(AccountEntity(accountId = null, document = query.get().document, balance = BigDecimal.ZERO))
        return query
    }
}