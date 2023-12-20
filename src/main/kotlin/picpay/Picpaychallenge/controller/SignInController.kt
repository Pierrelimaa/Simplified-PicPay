package picpay.Picpaychallenge.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import picpay.Picpaychallenge.controller.Dto.UserDto
import picpay.Picpaychallenge.useCases.UseCases

@RestController
@RequestMapping("/sign-in")
class SignInController(
    private val useCases: UseCases
) {


    @PostMapping("/create-user")
    fun createUser(
        @RequestBody payload: UserDto
    ): ResponseEntity<String> {
        return useCases.createUser(payload)

    }
}