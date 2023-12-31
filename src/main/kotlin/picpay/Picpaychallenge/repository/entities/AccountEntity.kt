package picpay.Picpaychallenge.repository.entities

import jakarta.persistence.*
import picpay.Picpaychallenge.domain.Account
import java.math.BigDecimal

@Entity
@Table(name = "account_tb")
data class AccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    val accountId: Long?,
    @Column(name = "document", unique = true)
    val document: String,
    @Column(name = "balance")
    val balance: BigDecimal
) {
    fun toAccount(): Account = Account(
        userDocument = document, amount = balance

    )
}

