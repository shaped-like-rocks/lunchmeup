package lunchmeup.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import lunchmeup.domain.Location

@RestController
class LocationsController {

    @GetMapping("/locations")
    fun getLocations() = listOf(
        Location("location1"),
        Location("location2"),
        Location("location3"),
        Location("location4")
    )
}