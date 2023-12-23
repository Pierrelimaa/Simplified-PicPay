package picpay.Picpaychallenge.controller.Dto

import java.io.Serializable
import java.math.BigDecimal

data class TransferDto(
    val amount: BigDecimal
): Serializable
