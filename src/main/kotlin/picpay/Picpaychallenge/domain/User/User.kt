package picpay.Picpaychallenge.domain.User

open class User(
    open val name : String,
    open val document: String,
    open val email: String,
    open val password: String
) {
}

fun String.isValidDocument(): Boolean {
    return when (length){
        11 -> true
        14 -> true
        else -> throw RuntimeException("Invalid cpf format")
    }
}