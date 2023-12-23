package picpay.Picpaychallenge.useCases

import org.springframework.stereotype.Component
import picpay.Picpaychallenge.useCases.balance.BalanceUseCaseImpl
import picpay.Picpaychallenge.useCases.persist.PersistUserUseCaseImpl
import picpay.Picpaychallenge.useCases.transaction.TransactionUseCaseImpl

@Component
class UseCases(
    val makeTransaction: TransactionUseCaseImpl,
    val retrieveBalance: BalanceUseCaseImpl,
    val createUser: PersistUserUseCaseImpl
)