package mockdata

import model.*

object MockCityEntity {

    //region CityHasCheapestInternetConnectionInteractor (Problem 1)
    fun createMockCity(cityName: String, averageMonthlyNetSalaryAfterTax: Float?, internetPrice: Float?): CityEntity {
        return CityEntity(
            cityName,
            "Egypt",
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                internetPrice,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            averageMonthlyNetSalaryAfterTax,
            true
        )

    }
    //endregion CityHasCheapestInternetConnectionInteractor (Problem 1)

    //region TopCitiesFruitsAndVegetablesLowestCostInteractor (Problem 2)
    fun createMockCity(
        cityName: String,
        fruitAndVegetablesPrices: FruitAndVegetablesPrices,
        averageMonthlyNetSalaryAfterTax: Float?
    ): CityEntity {
        return CityEntity(
            cityName,
            "England",
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            fruitAndVegetablesPrices,
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            averageMonthlyNetSalaryAfterTax,
            true
        )

    }
    //endregion TopCitiesFruitsAndVegetablesLowestCostInteractor (Problem 2)

    //region SalaryAverageForCitiesInCountryInteractor (Problem 3)
    fun createMockCity(
        countryName: String,
        cityName: String,
        averageMonthlyNetSalaryAfterTax: Float?,
        dataQuality: Boolean
    ): CityEntity {
        return CityEntity(
            cityName,
            countryName,
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            averageMonthlyNetSalaryAfterTax,
            dataQuality,
        )

    }
    //endregion SalaryAverageForCitiesInCountryInteractor (Problem 3)

    //region CityHasHighestDifferentRentBetweenCityCenterAndOutsideInteractor (Problem 4)
    fun createMockCity(
        apartmentOneBedroomInCityCentre: Float?,
        apartmentOneBedroomOutsideOfCentre: Float?,
        apartment3BedroomsInCityCentre: Float?,
        apartment3BedroomsOutsideOfCentre: Float?,
        dataQuality: Boolean
    ): CityEntity {
        return CityEntity(
            "Paris",
            "France",
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                apartmentOneBedroomInCityCentre,
                apartmentOneBedroomOutsideOfCentre,
                apartment3BedroomsInCityCentre,
                apartment3BedroomsOutsideOfCentre,
                null,
                null
            ),
            null,
            dataQuality,
        )

    }
    //endregion CityHasHighestDifferentRentBetweenCityCenterAndOutsideInteractor (Problem 4)

    //region Top5CitiesNameHasSuitableClothesPricesInteractor (Problem 5)
    fun createMockCity(
        cityName: String,
        clothesPrices: ClothesPrices
    ): CityEntity {
        return CityEntity(
            cityName,
            "Netherlands",
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            clothesPrices,
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            null,
            true,
        )

    }
    //endregion Top5CitiesNameHasSuitableClothesPricesInteractor (Problem 5)

    //region CityHasLowestYearsToBuyApartmentInteractor (Problem 6)
    fun createMockCity(
        cityName: String,
        pricePerSquareMeterToBuyApartmentOutsideOfCentre: Float?,
        dataQuality: Boolean,
        averageMonthlyNetSalaryAfterTax :Float?
    ): CityEntity {
        return CityEntity(
            cityName,
            "Columbia",
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                pricePerSquareMeterToBuyApartmentOutsideOfCentre,
            ), averageMonthlyNetSalaryAfterTax ,
            dataQuality,
        )

    }
    //endregion CityHasLowestYearsToBuyApartmentInteractor (Problem 6)

    //region CheapestBananaCitiesNamesInteractor (Problem 7)
    fun createMockCity(cityName: String, bananaPrice: Float?): CityEntity {
        return CityEntity(
            cityName,
            "Iraq",
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                bananaPrice,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            null,
            true
        )

    }
    //endregion CheapestBananaCitiesNamesInteractor(Problem 7)

    //region CityHasCheapestMealPricesInteractor (Problem 8)
    fun createMockCity(countryName: String, cityName: String, mealsPrices: MealsPrices): CityEntity {
        return CityEntity(
            cityName,
            countryName,
            mealsPrices,
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            null,
            true
        )

    }
    //endregion CityHasCheapestMealPricesInteractor (Problem 8)

    //region CheapestBasicPricesInAllCitiesComparingToAverageSalariesInteractor (Problem 8)
    fun createMockCity( mealsPrices: MealsPrices): CityEntity {
        return CityEntity(
            "cityName",
            "countryName",
            mealsPrices,
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            null,
            true
        )

    }
    //endregion CityWithCheapestInternationalPrimarySchoolForOneChildInteractor (Problem 8)

    //region TopTenCountryEnforceHighTaxesOnCarbonatedDrinksInteractor (Problem 9)
    fun createMockCity(
        countryName: String,
        dataQuality: Boolean,
        cocaPepsiPrice: Float?
    ): CityEntity {
        return CityEntity(
            "Honey City",
            countryName,
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                cocaPepsiPrice,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            null,
            dataQuality
        )

    }
    //endregion TopTenCountryEnforceHighTaxesOnCarbonatedDrinksInteractor (Problem 9)

    //region SuitableCityMoreSavingPerMonthInteractor (Problem 10)
    fun createMockCity(
        foodPrices: FoodPrices,
        averageMonthlyNetSalaryAfterTax: Float?,
        apartment3BedroomsInCityCentre: Float?
    ): CityEntity {
        return CityEntity(
            "Cairo",
            "Egypt",
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            foodPrices,
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                apartment3BedroomsInCityCentre,
                null,
                null,
                null
            ),
            averageMonthlyNetSalaryAfterTax,
            true
        )

    }
    //endregion SuitableCityMoreSavingPerMonthInteractor (Problem 10)

    //region SearchCheapestCarInCountryInteractor (Problem 11)
    fun createMockCity(
        countryName: String,
        cityName: String,
        carsPrices: CarsPrices,
        averageMonthlyNetSalaryAfterTax: Float?
    ): CityEntity {
        return CityEntity(
            cityName,
            countryName,
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            carsPrices,
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            averageMonthlyNetSalaryAfterTax,
            true,
        )

    }
    //endregion SearchCheapestCarInCountryInteractor (Problem 11)

    //region CityHasMostSuitableFitnessClubInteractor (Problem 12)
    fun createMockCity(
        countryName: String,
        cityName: String,
        fitnessClubMonthlyFeeForOneAdult: Float?,
        oneWayTicketLocalTransport: Float?,
        dataQuality: Boolean
    ): CityEntity {
        return CityEntity(
            cityName,
            countryName,
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                fitnessClubMonthlyFeeForOneAdult,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                oneWayTicketLocalTransport,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            null,
            dataQuality
        )

    }
    //endregion CityHasMostSuitableFitnessClubInteractor (Problem 12)

    //region CityHasLowestYearsToBuyApartmentInteractor (Problem 13)
    fun createMockCity(
        countryName:  String,   cityName:  String,
        dataQuality: Boolean,
        oneSummerDressInAChainStoreZaraHAndM: Float?
    ): CityEntity {
        return CityEntity(
            cityName,
            countryName,
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                oneSummerDressInAChainStoreZaraHAndM,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
            ),
            null,
            dataQuality,
        )

    }
    //endregion CityHasLowestYearsToBuyApartmentInteractor (Problem 13)

    //region CityHasCheapestCappuccinoRegularInRestaurantsInteractor (Problem 14)
    fun createMockCity(
        cappuccinoRegularInRestaurants: Float?,
        countryName: String,
        cityName: String,
        dataQuality: Boolean
    ): CityEntity {
        return CityEntity(
            cityName,
            countryName,
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                cappuccinoRegularInRestaurants,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            null,
            dataQuality,
        )

    }
    //endregion SalaryAverageForCitiesInCountryInteractor (Problem 14)

    //region CityWithCheapestInternationalPrimarySchoolForOneChildInteractor (Problem 15)
    fun createMockCity(
        internationalPrimarySchoolYearlyForOneChild: Float?,
        cityName: String,
        dataQuality: Boolean,
    ): CityEntity {
        return CityEntity(
            cityName,
            "Columbia",
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                internationalPrimarySchoolYearlyForOneChild            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                null,
                null,
                null,
                null,
                null,
                null ,
            ),
            null,
            dataQuality,
        )

    }
    //endregion CityWithCheapestInternationalPrimarySchoolForOneChildInteractor (Problem 15)

    //region CityHasCheapestBasicPricesInteractor (Problem 16)
    fun createMockCity(
        countryName: String,
        averageMonthlyNetSalaryAfterTax: Float?,
        apartmentOneBedroomInCityCentre: Float?,
        basicElectricityHeatingCoolingWaterGarbageFor85m2Apartment : Float? ,
        monthlyPassRegularPrice : Float?
    ): CityEntity {
        return CityEntity(
            "cityName",
            countryName,
            MealsPrices(
                null,
                null,
                null
            ),
            DrinksPrices(
                null,
                null,
                null,
                null,
                null
            ),
            FruitAndVegetablesPrices(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            FoodPrices(
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ServicesPrices(
                basicElectricityHeatingCoolingWaterGarbageFor85m2Apartment,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            ClothesPrices(
                null,
                null,
                null,
                null
            ),
            TransportationsPrices(
                null,
                monthlyPassRegularPrice,
                null,
                null,
                null,
                null
            ),
            CarsPrices(
                null,
                null
            ),
            RealEstatesPrices(
                apartmentOneBedroomInCityCentre,
                null,
                null,
                null,
                null,
                null
            ),
            averageMonthlyNetSalaryAfterTax,
            true
        )

    }
    //endregion CityHasCheapestBasicPricesInteractor
}