package picpay.Picpaychallenge.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import picpay.Picpaychallenge.useCases.UseCases
import picpay.Picpaychallenge.useCases.balance.toBalanceDto

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
        return balance?.toBalanceDto()
    }
}