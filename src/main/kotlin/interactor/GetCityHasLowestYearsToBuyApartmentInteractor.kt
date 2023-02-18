package interactor

import model.CityEntity

class GetCityHasLowestYearsToBuyApartmentInteractor(
    private val dataSource: CostOfLivingDataSource,
) {
    fun execute(limit: Int): List<Pair<String, Float>> {
        return (dataSource
            .getAllCitiesData()
            .filter(::excludeNullSalariesAndNullPricePerSquareApartmentAndLowQualityData)
            .sortedBy { getNumberOfYearsToBuyApartment(it) }
            .takeIf { (limit > 0) } ?: throw Exception("Not valid limit or full time salary"))
            .take(limit)
            .map { Pair(it.cityName, getNumberOfYearsToBuyApartment(it)) }
    }

    fun excludeNullSalariesAndNullPricePerSquareApartmentAndLowQualityData(city: CityEntity): Boolean {
        return city.run {
            realEstatesPrices.pricePerSquareMeterToBuyApartmentOutsideOfCentre != null && dataQuality
                    && averageMonthlyNetSalaryAfterTax != null
        }
    }

    private fun getNumberOfYearsToBuyApartment(city: CityEntity): Float {
        return city.run {
            realEstatesPrices.pricePerSquareMeterToBuyApartmentOutsideOfCentre!!
                .div(averageMonthlyNetSalaryAfterTax!! * 12) * 100
        }
    }

}