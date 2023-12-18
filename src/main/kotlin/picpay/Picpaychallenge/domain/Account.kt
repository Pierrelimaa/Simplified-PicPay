package picpay.Picpaychallenge.domain

import picpay.Picpaychallenge.domain.User.User
import java.math.BigDecimal

data class Account(
    val user: User,
    val amount: BigDecimal
){

    fun getBalance(){
        TODO()
    }

    fun tranfer(){
        TODO()
    }
}
