package apitutorial.apitutotorial.controller

import apitutorial.apitutotorial.model.Bank
import apitutorial.apitutotorial.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/banks")
class BankController (private val service: BankService){

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping
    fun getBanks() : Collection<Bank> = service.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBanks(@PathVariable accountNumber: String) : Bank = service.getBank(accountNumber)
}