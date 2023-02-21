package interactor

import model.CityEntity

class GetCityHasCheapestBasicPricesInteractor(
    private val dataSource: CostOfLivingDataSource
) {
    fun execute(): CityEntity? {
        return dataSource
            .getAllCitiesData()
            .filter(::excludeNullSalaryLowQualityDataAndOtherBasicPrices)
            .maxByOrNull {
                it.run {
                    averageMonthlyNetSalaryAfterTax!! -
                            (transportationsPrices.monthlyPassRegularPrice!!
                                    + servicesPrices.basicElectricityHeatingCoolingWaterGarbageFor85m2Apartment!!
                                    + realEstatesPrices.apartmentOneBedroomInCityCentre!!)
                }
            }
    }

    fun excludeNullSalaryLowQualityDataAndOtherBasicPrices(cityEntity: CityEntity): Boolean {
        return cityEntity.run {
            dataQuality
                    && averageMonthlyNetSalaryAfterTax != null
                    && realEstatesPrices.apartmentOneBedroomInCityCentre != null
                    && servicesPrices.basicElectricityHeatingCoolingWaterGarbageFor85m2Apartment != null
                    && transportationsPrices.monthlyPassRegularPrice != null
        }
    }
}