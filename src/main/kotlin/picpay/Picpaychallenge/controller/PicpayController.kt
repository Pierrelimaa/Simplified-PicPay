package picpay.Picpaychallenge.controller

import org.springframework.web.bind.annotation.*
import picpay.Picpaychallenge.controller.Dto.BalanceDto
import picpay.Picpaychallenge.controller.Dto.TransferDto
import picpay.Picpaychallenge.useCases.UseCases
import picpay.Picpaychallenge.useCases.transaction.TransactionInput

@RestController
@RequestMapping("/picpay/")
class PicpayController(
    val useCases: UseCases,
) {


    @PostMapping("/transaction")
    fun makeTransaction(
        @RequestParam("senderDocument") senderDocument: String,
        @RequestParam("password") password: String,
        @RequestParam("receiverDocument") receiverDocument: String,
        @RequestBody(required = true) transferAmount : TransferDto
    ) {
        val input = TransactionInput(
            senderDocument = senderDocument,
            senderPassword = password,
            receiverDocument = receiverDocument,
            transactionAmount = transferAmount.amount
        )
        useCases.makeTransaction(input)
    }

    @GetMapping("/balance")
    fun getBalance(
        @RequestHeader("document") document: String,
        @RequestHeader("password") password: String,
    ): BalanceDto? {
        val balance = useCases.retrieveBalance(document, password)
        return BalanceDto(balance.userDocument, balance.amount)
    }


}