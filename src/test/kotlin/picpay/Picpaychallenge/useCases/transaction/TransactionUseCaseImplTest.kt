package picpay.Picpaychallenge.useCases.transaction

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import picpay.Picpaychallenge.domain.Account
import picpay.Picpaychallenge.domain.Enum.UserTypeEnum
import picpay.Picpaychallenge.domain.User.User
import picpay.Picpaychallenge.services.interfaces.AccountService
import picpay.Picpaychallenge.services.interfaces.DatabaseService
import picpay.Picpaychallenge.services.interfaces.TransactionService
import picpay.Picpaychallenge.services.interfaces.dtos.TransactionDto
import picpay.Picpaychallenge.services.interfaces.dtos.TransferDTO
import picpay.Picpaychallenge.useCases.UseCases
import picpay.Picpaychallenge.useCases.balance.BalanceUseCaseImpl
import java.math.BigDecimal


class TransactionUseCaseImplTest{

    @Mock
    private lateinit var databaseService: DatabaseService

    @Mock
    private lateinit var accountService: AccountService

    @Mock
    private lateinit var balanceUseCase: BalanceUseCaseImpl

    @Mock
    private lateinit var transactionService: TransactionService

    @InjectMocks
    private lateinit var transactionUseCase: TransactionUseCaseImpl

    init {
        MockitoAnnotations.openMocks(this)
    }

    private  val transactionInput = TransactionInput(
        senderDocument = "03154145622", senderPassword = "1234", receiverDocument = "03154145655", transactionAmount = BigDecimal(1000)
    )

    private val senderAccount = Account(
        userDocument = "03154145622",
        amount = BigDecimal(1500)
    )
    private val senderUser = User(
        name = "Paulo", document = "03154145622", email = "paulo@gmail.com", password = "1234", userType = UserTypeEnum.COMMOM

    )


    @Test
    fun `must complete the transaction`() {

        //Arrange
        `when`(databaseService.retrieveUser(transactionInput.senderDocument)).thenReturn(senderUser)
        `when`(balanceUseCase.invoke(transactionInput.senderDocument, transactionInput.senderPassword)).thenReturn(senderAccount)

        // Act
        transactionUseCase(transactionInput)

        // Assert
        verify(accountService).transfer(TransferDTO(senderAccount, transactionInput.receiverDocument, transactionInput.transactionAmount))
        verify(transactionService).persistTransaction(TransactionDto(null, transactionInput.senderDocument, transactionInput.receiverDocument, transactionInput.transactionAmount))
        
        
        
    }


}



