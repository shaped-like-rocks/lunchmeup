package lunchmeup

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LunchmeupApplication

fun main(args: Array<String>) {
    runApplication<LunchmeupApplication>(*args)
}
