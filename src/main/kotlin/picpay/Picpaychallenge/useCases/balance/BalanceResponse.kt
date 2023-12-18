package picpay.Picpaychallenge.useCases.balance

import picpay.Picpaychallenge.controller.BalanceDto
import java.math.BigDecimal

data class BalanceResponse(
    val amount: BigDecimal
)


fun BalanceResponse.toBalanceDto() = BalanceDto(currentAmount = amount)
