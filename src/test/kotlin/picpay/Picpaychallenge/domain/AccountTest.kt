package picpay.Picpaychallenge.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal

internal class AccountTest {

    private val senderAccount = Account(
        userDocument = "03154145622",
        amount = BigDecimal(1500)
    )

    private val receiverAccount = Account(
        userDocument = "03154145655",
        amount = BigDecimal(1000)
    )

    @Test
    fun `must return that account has enough money to transfer`() {
        val hasAmountToTransfer =  senderAccount.hasAmountToTrasfer(BigDecimal(1000))

        assertSame(hasAmountToTransfer, true)
    }

    @Test
    fun `must subtract an amount of sender account` (){

        val senderAccountAfterTransfer = senderAccount.subtractAmount(takenAmount = BigDecimal(400))

        assert(senderAccountAfterTransfer.amount == BigDecimal(1100))
    }

    @Test
    fun `must add an amount to receiver account`() {

        val receiverAccountAfterTransfer = receiverAccount.addAmount(transferAmount = BigDecimal(400))

        assert(receiverAccountAfterTransfer.amount == BigDecimal(1400))
    }
}