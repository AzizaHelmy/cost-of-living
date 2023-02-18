package interactor

import model.CityEntity
import kotlin.math.ceil
import kotlin.math.floor

class GetCityHasAverageMealPricesInteractor(
    private val dataSource: CostOfLivingDataSource
) {

    fun execute(): CityEntity {
        return dataSource.getAllCitiesData()
            .filter { isCitiesInUSACanadaAndMexico(it) && excludeNullMealPrices(it) }
            .sortedByDescending { it.mealsPrices.getAverageMealInCity(it) }
            .takeIf { it.isNotEmpty() }
            ?.let(::getAverageMealInAllCities)
            ?: throw Throwable("List of cities is empty")
    }

    fun isCitiesInUSACanadaAndMexico(city: CityEntity): Boolean {
        return city.country in listOf(
            ThreeSpecificCountries.USA.nameOFCountry,
            ThreeSpecificCountries.CANADA.nameOFCountry,
            ThreeSpecificCountries.MEXICO.nameOFCountry
        )
    }


    fun excludeNullMealPrices(city: CityEntity): Boolean {
        return city.mealsPrices.run {
            (mealFor2PeopleMidRangeRestaurant != null) ||
                    (mealInexpensiveRestaurant != null && mealAtMcDonaldSOrEquivalent != null)
        }
    }

    private fun getAverageMealInAllCities(cityEntityList: List<CityEntity>): CityEntity? {
        if (cityEntityList.isEmpty()) return null
        val averageMealPricesInAllCities =
            (cityEntityList.first().mealsPrices.getAverageMealInCity(cityEntityList.first())!! +
                    cityEntityList.last().mealsPrices.getAverageMealInCity(cityEntityList.last())!!).div(2)

        return cityEntityList.first {
            (it.mealsPrices.getAverageMealInCity(it) == averageMealPricesInAllCities)
                    || (it.mealsPrices.getAverageMealInCity(it) == floor(averageMealPricesInAllCities))
                    || (it.mealsPrices.getAverageMealInCity(it) == ceil(averageMealPricesInAllCities))
        }
    }

}
enum class ThreeSpecificCountries(val nameOFCountry: String) {
    USA("United States"),
    CANADA("Canada"),
    MEXICO("Mexico"),
    EGYPT("Egypt")
}