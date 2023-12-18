package picpay.Picpaychallenge.domain.User

open class User(
    open val name : String,
    open val document: String,
    open val email: String,
    open val password: String
) {

    fun validateDocument() {
        when (document.length){
            11 -> return
            14 -> return
            else -> throw RuntimeException("Invalid cpf format")
        }

    }
}

fun String.isValidDocument(): Boolean {
    return when (length){
        11 -> true
        14 -> true
        else -> throw RuntimeException("Invalid cpf format")
    }
}