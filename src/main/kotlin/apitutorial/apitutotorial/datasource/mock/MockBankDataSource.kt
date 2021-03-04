package apitutorial.apitutotorial.datasource.mock
import apitutorial.apitutotorial.model.Bank
import apitutorial.apitutotorial.datasource.BankDataSource
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    val banks = listOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("1234", 0.0, 100),

        )
    override fun retrieveBanks() : Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() {it.accountNumber == accountNumber}
            ?: throw NoSuchElementException("Could not find  bank with account number $accountNumber")

}