package picpay.Picpaychallenge.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import picpay.Picpaychallenge.domain.User.CustomerUser
import picpay.Picpaychallenge.services.interfaces.BalanceService
import picpay.Picpaychallenge.useCases.balance.BalanceResponse

@Repository
class BalanceServiceImpl(): BalanceService {

    companion object{
        val logger = LoggerFactory.getLogger(javaClass)
    }

    override fun getBalance(): BalanceResponse? {
        TODO("Not yet implemented")
//        if(!isPasswordCorrect(password)){
//            return null
//        }
    }

    fun retrieveUser(document: String): CustomerUser? {


        return CustomerUser(
            name = "Pierre", document = "12345678900", email = "pi123@email.com", password = "1234"
        )
    }
    private fun isPasswordCorrect(password: String): Boolean {
        return if (password != "1234") {
            logger.error("Cannot access because password is incorrect")
            false
        } else true
    }


}


