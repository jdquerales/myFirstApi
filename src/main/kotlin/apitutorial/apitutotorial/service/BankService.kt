package apitutorial.apitutotorial.service

import org.springframework.stereotype.Service
import apitutorial.apitutotorial.datasource.BankDataSource
import apitutorial.apitutotorial.model.Bank


@Service
class BankService (private val dataSource: BankDataSource ) {
    fun getBanks(): Collection<Bank>{
        return dataSource.retrieveBanks()
    }

    fun getBank(accountNumber: String) : Bank = dataSource.retrieveBank(accountNumber)
}