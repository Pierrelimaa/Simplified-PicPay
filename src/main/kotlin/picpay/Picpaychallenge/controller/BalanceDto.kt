package picpay.Picpaychallenge.controller

import java.math.BigDecimal

data class BalanceDto(
    val name: String,
    val currentAmount: BigDecimal)