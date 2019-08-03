package rocks.like.shaped.lunchmeup

import it.skrape.matchers.toBe
import it.skrape.matchers.toBePresent
import it.skrape.mockmvc.andExpectHtml
import it.skrape.selects.element
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
internal class MainPageControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    internal fun `check react entry point is present`() {
        doMainPageCall()
                .andExpectHtml {
                    selectFirst("div").attr("id") toBe "app"
                }
    }

    @Test
    internal fun `check css bundle is added`() {
        doMainPageCall()
                .andExpectHtml {
                    selectFirst("link[rel=stylesheet]").attr("href") toBe "/dist/bundle.css"
                }
    }

    @Test
    internal fun `check meta information is present`() {
        doMainPageCall()
                .andExpectHtml {
                    element("title").text() toBe "LunchMeUp!"
                    element("meta[charset=utf-8]").toBePresent()
                }
    }

    private fun doMainPageCall(): ResultActions =
            mockMvc.perform(get("/"))
                    .andExpect {
                        status().is2xxSuccessful
                    }
}