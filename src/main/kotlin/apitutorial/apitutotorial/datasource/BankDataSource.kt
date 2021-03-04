package apitutorial.apitutotorial.datasource
import  apitutorial.apitutotorial.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>   // will return a collection of or Bank entities
    fun retrieveBank(accountNumber : String) : Bank
}