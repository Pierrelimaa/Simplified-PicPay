package picpay.Picpaychallenge.controller.Dto

import java.math.BigDecimal

data class BalanceDto(
    val document: String,
    val currentAmount: BigDecimal)