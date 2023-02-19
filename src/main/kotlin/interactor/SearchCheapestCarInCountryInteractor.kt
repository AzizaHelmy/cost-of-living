package interactor

import model.CityEntity

/**
 * Created by Mohamed Elgohary on 2/17/2023.
 */
class SearchCheapestCarInCountryInteractor(
    private val dataSource: CostOfLivingDataSource
) {
    fun execute(countryName: String, limit: Int): List<Pair<String, Float>> {
        return dataSource.getAllCitiesData()
            .filter {
                excludeNullCarsPricesAndSalaries(it)
                        && it.country.equals(countryName, true)
            }
            .sortedBy(::getNumberOfMonthsToBuyACar)
            .take(limit)
            .map {
                "You can buy the car after working ${getNumberOfMonthsToBuyACar(it)} months " +
                        "in ${it.cityName}" to getCheapestCar(
                    it
                )
            }
            .takeIf { it.isNotEmpty() } ?: throw Exception("No cities found in country $countryName")
    }

    private fun getNumberOfMonthsToBuyACar(city: CityEntity) =
        (getCheapestCar(city) / city.averageMonthlyNetSalaryAfterTax!!)

    fun getCheapestCar(city: CityEntity) = city.carsPrices.run {
        minOf(
            volkswagenGolf_1_4_90kwTrendLineOrEquivalentNewCar!!,
            toyotaCorollaSedan_1_6l_97kwComfortOrEquivalentNewCar!!
        )
    }
    fun excludeNullCarsPricesAndSalaries(city: CityEntity) = city.run {
        carsPrices.volkswagenGolf_1_4_90kwTrendLineOrEquivalentNewCar != null &&
                carsPrices.toyotaCorollaSedan_1_6l_97kwComfortOrEquivalentNewCar != null &&
                averageMonthlyNetSalaryAfterTax != null
    }
}