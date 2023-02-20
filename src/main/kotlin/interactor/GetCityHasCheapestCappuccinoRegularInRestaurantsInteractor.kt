package interactor

import model.CityEntity

/**
 *  Created by Rehab Fakhry on Sat, 2/18/2023 at 11:46 PM.
 */

class GetCityHasCheapestCappuccinoRegularInRestaurantsInteractor(
    private val dataSource: CostOfLivingDataSource
) {
    fun execute(countryName: String): List<Pair<String, Float>> {

        return dataSource
            .getAllCitiesData()
            .filter {
                excludeNullCappuccinoRegularInRestaurantsAndLowQualityData(it) &&
                        it.country == countryName
            }
            .sortedBy { it.drinksPrices.cappuccinoRegularInRestaurants }
            .map { Pair(it.cityName, it.drinksPrices.cappuccinoRegularInRestaurants!!) }
            .takeIf { it.isNotEmpty() } ?: throw Exception("No cities found in country $countryName")
    }

    fun excludeNullCappuccinoRegularInRestaurantsAndLowQualityData(city: CityEntity): Boolean {
        return city.run {
            drinksPrices.cappuccinoRegularInRestaurants != null
                    && dataQuality
        }
    }
}
