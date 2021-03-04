package apitutorial.apitutotorial
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping


@RestController
@RequestMapping("/api/hello")
class HelloWorldController {

    @GetMapping
    fun helloWorld(): String {
        return "Hello, this is a REST endpoint!"
    }
}

