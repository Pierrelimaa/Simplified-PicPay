package picpay.Picpaychallenge.services.interfaces.dtos

import picpay.Picpaychallenge.domain.Account
import java.math.BigDecimal

data class TransferDTO (
    val senderAccount: Account,
    val receiverDocument: String,
    val amountToTransfer: BigDecimal
        )
