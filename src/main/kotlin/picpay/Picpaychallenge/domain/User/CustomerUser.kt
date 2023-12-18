package picpay.Picpaychallenge.domain.User

data class CustomerUser(
    override val name: String,
    override val document:String,
    override val email: String,
    override val password: String
): User(name, document, email, password)
