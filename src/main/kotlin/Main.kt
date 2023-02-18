import dataSource.CsvDataSource
import dataSource.utils.CsvParser
import dataSource.utils.GetCityNamesClothesPrices
import enums.TheTypeOfApartments
import interactor.*
import interactor.CostOfLivingDataSource
import interactor.GetCityHasLowestYearsToBuyApartmentInteractor
import interactor.GetCityHasCheapestMealPricesInteractor
import interactor.GetSalaryAverageForCitiesInCountryInteractor

fun main() {
    val csvParser = CsvParser()
    val dataSource: CostOfLivingDataSource = CsvDataSource(csvParser)


    val getCityHasLowestYearsToBuyApartment = GetCityHasLowestYearsToBuyApartmentInteractor(dataSource)
    println(getCityHasLowestYearsToBuyApartment.execute(10))
    println(getCityHasLowestYearsToBuyApartment.execute(7))
    println(getCityHasLowestYearsToBuyApartment.execute(1))
    printSeparationLine()

}

private fun printSeparationLine() {
    print("\n_______________________________\n")
}

