package lunchmeup.domain.meal

data class Price(
        val amount: Int,
        val currency: Currency
)

enum class Currency(
        val displayName: String,
        val symbol: String
) {
    EUR("Euro", "€"),
    USD("US Dollar", "$"),
    NOK("kroner", "kr")
}