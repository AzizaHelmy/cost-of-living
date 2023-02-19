package interactor

import model.CityEntity

class GetCityHasMostSuitableFitnessClubInteractor(private val dataSource: CostOfLivingDataSource) {

    fun execute(limit: Int): List<Triple<String, Float, Float>> {
        takeIf { limit > 0 } ?: throw Throwable("Limit is negative")
        return dataSource
            .getAllCitiesData()
            .filter {
                isCitiesInUnitedKingdomGermanyAndFrance(it)
                        && excludeLowQualityData(it)
                        && isCityHasFitnessClubMonthlyFeeForOneAdult(it)
            }
            .sortedBy {
                isCityHasPriceOfTransportationOfOneWayTicket(it)
            }
            .take(limit)
            .map {
                Triple(
                    it.cityName,
                    it.servicesPrices.fitnessClubMonthlyFeeForOneAdult!!,
                    it.transportationsPrices.oneWayTicketLocalTransport!!
                )
            }
    }

    fun excludeLowQualityData(city: CityEntity): Boolean {
        return city.dataQuality
    }

    fun isCitiesInUnitedKingdomGermanyAndFrance(city: CityEntity): Boolean {
        return city.run {
            country == SpecificCountries.UNITED_KINGDOM.nameOfCountry
                    || country == SpecificCountries.GERMANY.nameOfCountry
                    ||country == SpecificCountries.FRANCE.nameOfCountry
        }
    }

    fun isCityHasPriceOfTransportationOfOneWayTicket(city: CityEntity): Float? {
        return city.transportationsPrices.oneWayTicketLocalTransport
    }

    fun isCityHasFitnessClubMonthlyFeeForOneAdult(city: CityEntity): Boolean {
        return city.servicesPrices.fitnessClubMonthlyFeeForOneAdult != null
    }
}

enum class SpecificCountries(val nameOfCountry: String) {
    UNITED_KINGDOM("United Kingdom"),
    GERMANY("Germany"),
    FRANCE("France")
}