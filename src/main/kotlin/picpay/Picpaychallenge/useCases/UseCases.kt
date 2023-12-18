package picpay.Picpaychallenge.useCases

import org.springframework.stereotype.Component
import picpay.Picpaychallenge.useCases.balance.BalanceUseCaseImpl

@Component
class UseCases(
    val makeTransaction: TransactionImpl,
    val retrieveBalance: BalanceUseCaseImpl
)