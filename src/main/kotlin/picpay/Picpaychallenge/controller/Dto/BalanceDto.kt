package picpay.Picpaychallenge.controller.Dto

import java.math.BigDecimal

data class BalanceDto(
    val name: String,
    val currentAmount: BigDecimal)