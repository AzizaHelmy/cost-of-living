package interactor

import model.CityEntity

class GetCityHasCheapestDressPriceInteractor(private val dataSource: CostOfLivingDataSource) {

    fun execute(limit: Int, countryName: String): List<Pair<String, Float>> {
        return dataSource
            .getAllCitiesData()
            .filter { city -> excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(city, countryName) }
            .sortedBy { city -> city.clothesPrices.oneSummerDressInAChainStoreZaraHAndM }
            .takeIf { city -> city.isNotEmpty() }?.let {
                it.take(limit)
                .map { Pair(it.cityName, it.clothesPrices.oneSummerDressInAChainStoreZaraHAndM!!) }
            } ?: throw Exception("No cities found in country $countryName")

    }
    fun excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(city: CityEntity, countryName: String): Boolean {
        return city.run {
            clothesPrices.oneSummerDressInAChainStoreZaraHAndM != null
                    && dataQuality
                    && countryName == country
        }
    }

}