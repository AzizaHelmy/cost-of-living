package interactor

import model.CityEntity

class GetCityHasMostSuitableFitnessClubInteractor(private val dataSource: CostOfLivingDataSource) {

    fun execute(): List<Triple<String, Float, Float>> {
        TODO("NOT IMPLEMENTED YET")
    }

    fun excludeLowQualityData(city: CityEntity): Boolean {
        TODO("NOT IMPLEMENTED YET")
    }
}