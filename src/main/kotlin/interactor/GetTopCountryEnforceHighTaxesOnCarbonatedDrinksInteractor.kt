package interactor

import model.CityEntity

class GetTopCountryEnforceHighTaxesOnCarbonatedDrinksInteractor(private val dataSource: CostOfLivingDataSource) {
    fun execute(limit: Int): List<Pair<String, Float>> {
        return dataSource.getAllCitiesData()
            .asSequence()
            .filter(::excludeNullCarbonatedDrinkAndLowDataQuality)
            .distinctBy { it.country }
            .sortedByDescending { it.drinksPrices.cokePepsiAThirdOfLiterBottleInRestaurants }
            .take(limit)
            .map { Pair(it.country, it.drinksPrices.cokePepsiAThirdOfLiterBottleInRestaurants!!) }
            .toList()
    }

    private fun excludeNullCarbonatedDrinkAndLowDataQuality(city: CityEntity): Boolean {
        return city.run { drinksPrices.cokePepsiAThirdOfLiterBottleInRestaurants != null && dataQuality }
    }
}