package lunchmeup.api

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import strikt.api.expectThat
import strikt.assertions.contains
import strikt.assertions.isEqualTo

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
internal class LocationsControllerTest(
        @Autowired val mockMvc: MockMvc
) {

    @Test
    fun getLocations() {
        val response = mockMvc
                .perform(get("/locations"))
                .andReturn().response

        response.run {
            expectThat(status).isEqualTo(200)
            expectThat(contentAsString).contains("location1")
        }
    }
}