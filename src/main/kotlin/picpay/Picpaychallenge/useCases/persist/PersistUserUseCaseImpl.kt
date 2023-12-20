package picpay.Picpaychallenge.useCases.persist

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import picpay.Picpaychallenge.controller.UserDto
import picpay.Picpaychallenge.domain.User.User
import picpay.Picpaychallenge.services.interfaces.DatabaseService
import java.util.*

@Component
class PersistUserUseCaseImpl(
    private val databaseService: DatabaseService
) {

    operator fun invoke(payload: UserDto): ResponseEntity<String> {

        val newUser = User(name = payload.name, document = payload.document, email = payload.email, password = payload.password)

        val persistUser = databaseService.insertUser(newUser)
        return when {
            persistUser.isPresent -> ResponseEntity("User created - name:${persistUser.get().name} | document:${persistUser.get().document} ", HttpStatus.CREATED)
            else -> ResponseEntity<String>("" ,HttpStatus.BAD_REQUEST)
        }
    }

}
