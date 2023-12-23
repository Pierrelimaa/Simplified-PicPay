package picpay.Picpaychallenge.services.interfaces

import picpay.Picpaychallenge.services.interfaces.dtos.TransferDTO

interface AccountService {

    fun transfer(transferInput: TransferDTO)
}
