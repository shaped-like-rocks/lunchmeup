package io.github.alxndrhi.lunchmeup

import kotlinx.html.*
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
class MainPageController {
    @GetMapping("/")
    fun renderMainPage(): String {
        logger.debug { "mainPage has been called!" }
        return renderInitialMarkup()
    }

    fun renderInitialMarkup(): String =
            createHTMLDocument().html {

                head {
                    title { +"LunchMeUp!" }
                    meta(charset = "utf-8")
                    link(rel = "stylesheet", type = "text/css", href = "/dist/bundle.css") {}
                }

                body {
                    div {
                        id = "app"
                    }
                    script(src = "/dist/bundle.js") { }
                }
            }.serialize(true)
}
