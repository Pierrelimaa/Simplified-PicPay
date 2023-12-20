package picpay.Picpaychallenge.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import picpay.Picpaychallenge.controller.Dto.BalanceDto
import picpay.Picpaychallenge.controller.Dto.UserDto
import picpay.Picpaychallenge.useCases.UseCases

@RestController
@RequestMapping("/picpay/")
class PicpayController(
    val useCases: UseCases,
) {


    @PostMapping("/transaction")
    fun makeTransaction() {
        useCases.makeTransaction
    }

    @GetMapping("/balance")
    fun getBalance(
        @RequestHeader("document") document: String,
        @RequestHeader("password") password: String,
    ): BalanceDto? {
        val balance = useCases.retrieveBalance(document, password)
        return BalanceDto(balance.user.name, balance.amount)
    }


}