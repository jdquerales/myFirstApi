package apitutorial.apitutotorial.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import apitutorial.apitutotorial.datasource.BankDataSource
import io.mockk.mockk
import io.mockk.verify

internal class BankServiceTest {

    private val dataSource: BankDataSource = mockk(relaxed= true)

    private val bankService = BankService(dataSource)

    @Test
    fun `should call its data source to retrieve banks` () {
        //given

        // when
        val banks = bankService.getBanks()

        // then
        verify(exactly = 1) { dataSource.retrieveBanks() }
    }
}