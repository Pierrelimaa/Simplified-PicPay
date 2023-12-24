package picpay.Picpaychallenge.repository.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "transaction_tb")
data class TransactionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    val transactionId: Long?,
    @Column(name = "sender_document")
    val senderDocument: String,
    @Column(name = "receiver_document")
    val receiverDocument: String,
    @Column(name = "amount")
    val amount: BigDecimal

)
