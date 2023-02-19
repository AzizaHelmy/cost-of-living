package interactor

import model.CityEntity
import kotlin.math.abs

class GetCityHasHighestDifferentRentBetweenCityCenterAndOutsideInteractor(
    private val dataSource: CostOfLivingDataSource
) {

    fun execute(): CityEntity {
        return dataSource.getAllCitiesData()
            .filter {
                excludeLowQualityData(it)
                        && excludeNullRentForThreeBedRooms(it)
                        && excludeNullRentForOneBedRoom(it)
            }
            .maxByOrNull {
                with(it.realEstatesPrices) {
                    abs(apartmentOneBedroomOutsideOfCentre!! - apartmentOneBedroomInCityCentre!!) +
                            abs(apartment3BedroomsInCityCentre!! - apartment3BedroomsOutsideOfCentre!!)
                }
            } ?: throw Exception("invalid Data")
    }

    private fun excludeLowQualityData(city: CityEntity): Boolean {
        return city.dataQuality
    }

    private fun excludeNullRentForThreeBedRooms(city: CityEntity): Boolean {
        return city.realEstatesPrices.run {
            apartment3BedroomsInCityCentre != null
                    && apartment3BedroomsOutsideOfCentre != null
        }
    }

    private fun excludeNullRentForOneBedRoom(city: CityEntity): Boolean {
        return city.realEstatesPrices.run {
            apartmentOneBedroomInCityCentre != null
                    && apartmentOneBedroomOutsideOfCentre != null
        }
    }


}




