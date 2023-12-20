package picpay.Picpaychallenge.repository.entities

import jakarta.persistence.*
import picpay.Picpaychallenge.domain.User.User

@Entity
@Table(name = "user_tb")
data class UserEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    val userId: Long?,

    @Column(name = "name", length = 50, nullable = false)
    val name: String,

    @Column(name = "document", length = 14, nullable = false, unique = true)
    val document: String,

    @Column(name = "email", length = 50, nullable = false, unique = true)
    val email: String,

    @Column(name = "password", length = 50, nullable = false)
    val password: String,

    )