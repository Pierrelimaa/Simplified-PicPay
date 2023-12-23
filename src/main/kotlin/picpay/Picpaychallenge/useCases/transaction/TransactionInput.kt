package picpay.Picpaychallenge.useCases.transaction

import java.math.BigDecimal

data class TransactionInput(
    val senderDocument: String,
    val senderPassword: String,
    val receiverDocument: String,
    val transactionAmount: BigDecimal

) {
}
