package interactor

import model.CityEntity
import kotlin.math.abs

class GetCityHasHighestDifferentRentBetweenCityCenterAndOutsideInteractor(
    private val dataSource: CostOfLivingDataSource
) {

    fun execute(): CityEntity? {
     return   dataSource.getAllCitiesData()
         .filter{excludeLowQualityData(it) &&excludeNullRentForThreeBedRooms(it)
                 &&excludeNullRentForOneBedRoom(it)}
         .maxByOrNull { with(it.realEstatesPrices){
                 abs(apartmentOneBedroomOutsideOfCentre!! - apartmentOneBedroomInCityCentre!!) +
                         abs(apartment3BedroomsInCityCentre!! - apartment3BedroomsOutsideOfCentre!!)
             }!!
         }!!



        }
    private fun excludeLowQualityData(city: CityEntity): Boolean {
        return city.dataQuality


    }


    private fun excludeNullRentForThreeBedRooms(city: CityEntity): Boolean {
        return city.run {
            realEstatesPrices.apartment3BedroomsInCityCentre != null
                    && realEstatesPrices.apartment3BedroomsOutsideOfCentre != null
        }
    }

    private fun excludeNullRentForOneBedRoom(city: CityEntity): Boolean {
        return city.run {
            realEstatesPrices.apartmentOneBedroomInCityCentre != null
                    && realEstatesPrices.apartmentOneBedroomOutsideOfCentre != null
        }
    }


}




