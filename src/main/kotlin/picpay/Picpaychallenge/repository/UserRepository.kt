package picpay.Picpaychallenge.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import picpay.Picpaychallenge.repository.entities.UserEntity
import java.util.*

@Repository
interface UserRepository: JpaRepository<UserEntity, Long>{

    fun findByDocument(document: String): UserEntity
    fun save(newUser: UserEntity): Optional<UserEntity>
}