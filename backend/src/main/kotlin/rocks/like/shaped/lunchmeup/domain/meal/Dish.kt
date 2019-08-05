package rocks.like.shaped.lunchmeup.domain.meal

data class Dish(
        val name: String,
        val price: Price,
        val attributes: List<Attribute>
)

enum class Attribute(val displayName: String) {
    GLUTENFREE("glutenfree"),
    VEGAN("vegan"),
    VEGETARIAN("vegetarian"),
    LACTOSEFREE("lactosefree")
}