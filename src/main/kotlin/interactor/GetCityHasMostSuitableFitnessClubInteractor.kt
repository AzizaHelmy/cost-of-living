package interactor

import model.CityEntity

class GetCityHasMostSuitableFitnessClubInteractor(private val dataSource: CostOfLivingDataSource) {

    fun execute(): List<Triple<String, Float, Float>> {
        TODO("NOT IMPLEMENTED YET")
    }

    fun excludeLowQualityData(city: CityEntity): Boolean {
        return city.dataQuality
    }

    fun isCitiesInUnitedKingdomGermanyAndFrance(city: CityEntity): Boolean {
        return city.country == SpecificCountries.UNITED_KINGDOM.nameOfCountry
                || city.country == SpecificCountries.GERMANY.nameOfCountry
                || city.country == SpecificCountries.FRANCE.nameOfCountry
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