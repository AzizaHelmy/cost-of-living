package interactor

import model.CityEntity

class GetCityHasCheapestDressPriceInteractor (private val dataSource: CostOfLivingDataSource) {

    fun execute(limit :Int ,countryname:String): List<Pair<String, Float?>> {

        TODO("Not Implement yet")
    }

    fun excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(city: CityEntity,countryname:String): Boolean {
        TODO("Not Implement Yet")

    }

}