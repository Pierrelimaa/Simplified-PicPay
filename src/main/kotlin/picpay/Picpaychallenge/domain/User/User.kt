package picpay.Picpaychallenge.domain.User

import org.slf4j.LoggerFactory
import picpay.Picpaychallenge.domain.Exception.InvalidDocumentException
import picpay.Picpaychallenge.repository.entities.UserEntity

open class User(
    open val name : String,
    open val document: String,
    open val email: String,
    open val password: String
) {

    companion object{
        private val logger = LoggerFactory.getLogger(javaClass)
    }
    operator fun invoke(): User? {
        return try {
        when(document.length){
            11 -> CustomerUser(name, document, email, password)
            14 -> MerchantUser(name, document, email, password)
            else -> throw InvalidDocumentException("Invalid document format")
        }
        }
            catch(ex: Exception){
                logger.error("Document: $document has an invalid format")
                return null
        }

    }

    fun isPasswordCorrect(password: String): Boolean{
        return password == this.password
    }
    
    fun toUserEntity() = UserEntity(
        userId = null, name = name, document = document, email = email, password = password
    )

}
