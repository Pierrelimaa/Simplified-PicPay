package picpay.Picpaychallenge.repository.interfaces

import picpay.Picpaychallenge.useCases.balance.BalanceResponse

interface BalanceRepository{

    fun getBalance(): BalanceResponse?
}


