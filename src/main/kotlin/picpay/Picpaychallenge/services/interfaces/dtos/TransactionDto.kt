package picpay.Picpaychallenge.services.interfaces.dtos

import java.math.BigDecimal

data class TransactionDto(
    val Id: Long? = null,
    val senderDocument: String,
    val receiverDocument: String,
    val transferedAmount: BigDecimal
        )
