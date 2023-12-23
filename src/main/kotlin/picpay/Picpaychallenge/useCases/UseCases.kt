package picpay.Picpaychallenge.useCases

import org.springframework.stereotype.Component
import picpay.Picpaychallenge.useCases.balance.BalanceUseCaseImpl
import picpay.Picpaychallenge.useCases.persist.PersistUserUseCaseImpl
import picpay.Picpaychallenge.useCases.transaction.TransactionImpl

@Component
class UseCases(
    val makeTransaction: TransactionImpl,
    val retrieveBalance: BalanceUseCaseImpl,
    val createUser: PersistUserUseCaseImpl
)