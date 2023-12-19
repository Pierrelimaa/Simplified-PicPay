package picpay.Picpaychallenge.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import picpay.Picpaychallenge.repository.BalanceRepository
import picpay.Picpaychallenge.services.interfaces.BalanceService
import picpay.Picpaychallenge.useCases.balance.BalanceResponse

@Repository
class BalanceServiceImpl(
    private val balanceRepository: BalanceRepository,
) : BalanceService {

    companion object {
        val logger = LoggerFactory.getLogger(javaClass)
    }

    override fun getBalance(document: String): BalanceResponse {
        val accountBalance = balanceRepository.getBalanceByDocument(document)

        return if (accountBalance != null) {
            BalanceResponse(accountBalance.balance)
        } else {
            throw Exception("Balance not found for document $document")
        }
    }
}


