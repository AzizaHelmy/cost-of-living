package interactor

import model.CityEntity

class GetCityHasCheapestDressPriceInteractor (private val dataSource: CostOfLivingDataSource) {

    fun execute(limit :Int ,countryname:String): List<Pair<String, Float?>> {

        return (dataSource
            .getAllCitiesData()
            .filter {city-> excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(city,countryname)}
            .sortedBy { city-> city.clothesPrices.oneSummerDressInAChainStoreZaraHAndM}
            .takeIf { city-> city.isNotEmpty() } ?: throw Exception("No cities found in country $countryname"))
            .take(limit)
            .map {  Pair(it.cityName, it.clothesPrices.oneSummerDressInAChainStoreZaraHAndM)}    }

    fun excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(city: CityEntity,countryname:String): Boolean {
       return city.run { city.clothesPrices.oneSummerDressInAChainStoreZaraHAndM!=null &&city.dataQuality
        &&countryname==city.country}
    }

}