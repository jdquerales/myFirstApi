package apitutorial.apitutotorial.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.client.match.MockRestRequestMatchers.content
import org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.web.servlet.function.RequestPredicates.contentType
import javax.management.Query.value


@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest {

    @Autowired
    lateinit var mockMvc : MockMvc

    @Test
    fun `should return all banks`() {
        // when/then
        mockMvc.get("/api/banks")
            .andDo{ print() }
            .andExpect { status { isOk() }
             content { contentType(MediaType.APPLICATION_JSON) }
             jsonPath("$[0].accountNumber"){ value("1234")}


    }
}

    @Test
    fun `should return the bank with the given account number` () {
        // given
        val accountNumber = 1234

        // when
        mockMvc.get("/api/banks/$accountNumber")

        // then
            .andDo { print() }
            .andExpect { status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.trust"){ value("3.14")}
                jsonPath("$.transactionFee"){ value("17")}


            }

    }

    @Test
    fun `should return NOT FOUND if the account number does nor exist` () {
        // given
        val accountNumber = "does_not_exist"

        // when
        mockMvc.get("/api/banks/$accountNumber")

            // then
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }

}