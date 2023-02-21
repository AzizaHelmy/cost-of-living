package interactor

import model.CityEntity

class GetCityWithCheapestInternationalPrimarySchoolInteractor(
    private val dataSource: CostOfLivingDataSource
) {
    fun execute(limit: Int): List<Pair<String, Float>> {
        return takeIf { (limit >= 0) }?.let {
            dataSource
                .getAllCitiesData()
                .filter(::excludeNullInterNationalPrimarySchoolYearlyAndLowQualityData)
                .sortedBy { it.servicesPrices.internationalPrimarySchoolYearlyForOneChild }
                .take(limit)
                .map { Pair(it.cityName, it.servicesPrices.internationalPrimarySchoolYearlyForOneChild!!) }
        } ?: throw Exception("Not valid limit ")
    }

    fun excludeNullInterNationalPrimarySchoolYearlyAndLowQualityData(city: CityEntity): Boolean {
        return city.run {
            servicesPrices.internationalPrimarySchoolYearlyForOneChild != null
                    && dataQuality
        }
    }


}