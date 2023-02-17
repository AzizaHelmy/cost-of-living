package interactor

import model.CityEntity

/**
 * Created by Mohamed Elgohary on 2/16/2023.
 */
class SearchCheapestCarInCountryInteractor(
    private val dataSource: CostOfLivingDataSource
) {

    fun execute(countryName: String): List<Pair<String, Float?>> {
        return (dataSource.getAllCitiesData()
            .filter(::excludeNullCarsPrices)
            .filter { it.country.equals(countryName, true) }
            .takeIf { it.isNotEmpty() } ?: throw Exception("No cities found in country $countryName"))
            .map { city -> Pair(city.cityName, searchCheapestCar(city)) }
            .take(1)
         //   .sortedBy { it.second }
       //   .map { Pair(it.cityName, it.carsPrices.toyotaCorollaSedan_1_6l_97kwComfortOrEquivalentNewCar) }
    }


    private fun searchCheapestCar(city: CityEntity): Float {
        return minOf(city.carsPrices.volkswagenGolf_1_4_90kwTrendLineOrEquivalentNewCar!!,
            city.carsPrices.toyotaCorollaSedan_1_6l_97kwComfortOrEquivalentNewCar!!)
    }

    private fun excludeNullCarsPrices(city: CityEntity): Boolean {
        return city.carsPrices.volkswagenGolf_1_4_90kwTrendLineOrEquivalentNewCar != null &&
                city.carsPrices.toyotaCorollaSedan_1_6l_97kwComfortOrEquivalentNewCar != null
    }
}