package interactor

import model.CityEntity

class GetCityHasCheapestDressPrice (private val dataSource: CostOfLivingDataSource) {

    fun execute(countryname:String): List<Pair<String,Float?>> {
       TODO("Not Implement Yet")
    }
    fun excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(city: CityEntity,countryname:String): Boolean {
        TODO("Not Implement Yet")

    }

}