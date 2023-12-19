package picpay.Picpaychallenge.services.interfaces

import picpay.Picpaychallenge.useCases.balance.BalanceResponse

interface BalanceService{

    fun getBalance(document: String): BalanceResponse
}


