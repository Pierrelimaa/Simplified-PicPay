package picpay.Picpaychallenge.domain.User

import picpay.Picpaychallenge.domain.Enum.UserTypeEnum

data class MerchantUser(
    override val name : String,
    override val document: String,
    override val email: String,
    override val password: String,
    override val userType: UserTypeEnum
): User(name, document, email, password, userType)