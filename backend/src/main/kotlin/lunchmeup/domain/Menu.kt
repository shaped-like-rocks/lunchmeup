package lunchmeup.domain

import lunchmeup.domain.meal.Dish
import java.util.Date

data class Menu(
        val location: Location,
        val date: Date,
        val meals: List<Dish>
)