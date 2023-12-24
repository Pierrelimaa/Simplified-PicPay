package picpay.Picpaychallenge.services.interfaces

import picpay.Picpaychallenge.services.interfaces.dtos.TransactionDto

interface TransactionService {


    fun getTransactions() : Unit = TODO()


    fun persistTransaction(persistTransactionInput: TransactionDto)

}