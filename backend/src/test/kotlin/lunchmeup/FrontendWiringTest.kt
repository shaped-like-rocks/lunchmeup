package lunchmeup

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.contains
import strikt.assertions.isNotNull

class FrontendWiringTest {

    @Test
    internal fun `frontend bundle has been added to classpath`() {
        val classPath = System.getProperty("java.class.path")
        println(classPath.replace(":", "\n"))
        expectThat(classPath).contains("/backend/build/frontend:")
    }

    @Test
    internal fun `resource has correct path`() {
        val resource = javaClass.getResource("/static/bundle.js")
        expectThat(resource).isNotNull()
    }
}
