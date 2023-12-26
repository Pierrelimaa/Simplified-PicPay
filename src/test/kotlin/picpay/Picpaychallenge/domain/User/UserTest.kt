package picpay.Picpaychallenge.domain.User

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import picpay.Picpaychallenge.domain.Enum.UserTypeEnum

internal class UserTest(
) {

    private val commonUser = User(
        name = "Pedro", document = "01382834555", email = "pedro@gmail.com", password = "1234", userType = null
    )

    private val merchantUser = User(
        name = "Console Store",
        document = "02987479820001",
        email = "consoleS@gmail.com",
        password = "abcd",
        userType = null

    )

    @Test
    fun `User type must be COMMON`() {

        val user = commonUser.invoke()
        val clazz = user?.javaClass == CustomerUser::class.java

        assertSame(user?.userType, UserTypeEnum.COMMOM)
        assertSame(clazz, true)
    }

    @Test
    fun `User type must be MERCHANT`() {

        val user = merchantUser.invoke()
        val clazz = user?.javaClass == MerchantUser::class.java


        assertSame(user?.userType, UserTypeEnum.MERCHANT)
        assertSame(clazz, true)
    }

    @Test
    fun `Password must be correct`() {

        val user = commonUser.invoke()

        assertSame(user?.isPasswordCorrect("1234"), true)
    }

    @Test
    fun isMerchant() {

        val user = merchantUser.invoke()

        assertSame(user?.isMerchant(), true)
    }
}