package picpay.Picpaychallenge.domain

import java.math.BigDecimal

data class Account(
    val userDocument: String,
    val amount: BigDecimal
){

    fun hasAmountToTrasfer(sendAmount: BigDecimal): Boolean{
        return amount >= sendAmount
    }

    fun subtractAmount(takenAmount: BigDecimal): Account {
        val newAmount = amount.subtract(takenAmount)
        return Account(userDocument, newAmount)
    }
    fun addAmount(transferAmount: BigDecimal): Account{
        val newAmount = amount.plus(transferAmount)
        return Account(userDocument, newAmount)
    }
}
