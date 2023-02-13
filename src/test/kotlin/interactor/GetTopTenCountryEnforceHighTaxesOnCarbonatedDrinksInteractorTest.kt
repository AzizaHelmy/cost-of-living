package interactor

import dataSource.CsvDataSource
import dataSource.utils.CsvParser
import model.CityEntity
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetTopTenCountryEnforceHighTaxesOnCarbonatedDrinksInteractorTest {

    private lateinit var testingData: GetTopTenCountryEnforceHighTaxesOnCarbonatedDrinksInteractor
    private val csvParser = CsvParser()
    private val dataSource: CostOfLivingDataSource = CsvDataSource(csvParser)


    @BeforeAll
    fun setUpData() {
        testingData = GetTopTenCountryEnforceHighTaxesOnCarbonatedDrinksInteractor(dataSource)
    }

    @Test
    fun returnSizeOfList() {
        //given
        val limit = 10
        val cities = dataSource.getAllCitiesData()
        //when
        val result = testingData.execute(limit, cities)
        //then
        assertEquals(10, result.size)
    }


    @Test
    fun throwNullException() {
        //given
        lateinit var list : List<CityEntity>
        //when
        val noData = org.junit.jupiter.api.function.Executable { testingData.execute(10, list) }
        //then
        assertThrows(Exception::class.java , noData)
    }


}