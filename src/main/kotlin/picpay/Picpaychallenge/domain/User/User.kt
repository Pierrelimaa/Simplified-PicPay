package picpay.Picpaychallenge.domain.User

import org.slf4j.LoggerFactory
import picpay.Picpaychallenge.domain.Enum.UserTypeEnum
import picpay.Picpaychallenge.domain.Exception.InvalidDocumentException
import picpay.Picpaychallenge.repository.entities.UserEntity

open class User(
    open val name : String,
    open val document: String,
    open val email: String,
    open val password: String,
    open val userType: UserTypeEnum? = null
) {

    companion object{
        private val logger = LoggerFactory.getLogger(javaClass)
    }
    operator fun invoke(): User? {

        return when(document.length){
            11 -> CustomerUser(name, document, email, password, UserTypeEnum.COMMOM)
            14 -> MerchantUser(name, document, email, password, UserTypeEnum.MERCHANT)
            else -> throw InvalidDocumentException(message = "Invalid document format")
        }

    }

    fun isPasswordCorrect(password: String): Boolean{
        return password == this.password
    }

    fun isMerchant(): Boolean {

        return when (userType) {
            UserTypeEnum.COMMOM -> false
            UserTypeEnum.MERCHANT -> true
            else -> true
        }
    }
    
    fun toUserEntity() = UserEntity(
        userId = null, name = name, document = document, email = email, password = password
    )

}
