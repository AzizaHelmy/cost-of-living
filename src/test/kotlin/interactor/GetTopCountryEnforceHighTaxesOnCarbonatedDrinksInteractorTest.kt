package interactor

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import mockData.MockCityEntity.createMockCity
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetTopCountryEnforceHighTaxesOnCarbonatedDrinksInteractorTest {

    private lateinit var testingData: GetTopCountryEnforceHighTaxesOnCarbonatedDrinksInteractor
    private val dataSource = mockk<CostOfLivingDataSource>()

    @BeforeAll
    fun setUpData() {
        // clear and cancel all objects mock
        unmockkAll()
        clearAllMocks()

        //set testing data from HighTaxesOnCarbonatedDrinks class
        testingData = GetTopCountryEnforceHighTaxesOnCarbonatedDrinksInteractor(dataSource)
    }

    @Test
    fun `should return correct data when has a limit with correct data`() {
        //Given eight countries as a limit and set mockk data
        val limit = 8
        val mockCountry = listOf(
            createMockCity("Cuba", true, 2.0f),
            createMockCity("Egypt", true, 2.0f),
            createMockCity("Koura", true, 2.0f),
            createMockCity("Lebanon", true, 2.0f),
            createMockCity("Argentina", true, 2.0f),
            createMockCity("Loliput", true, 2.0f),
            createMockCity("Albania", true, 2.0f),
            createMockCity("Syria", true, .82f)
        )

        every { dataSource.getAllCitiesData() } returns mockCountry
        // When getting result
        val actualList = testingData.execute(limit)
        // Then return listOf Pair(country name and the average prices for those drinks for this country)
        val expectedList = listOf(
            Pair("Cuba", 2.0f),
            Pair("Egypt", 2.0f),
            Pair("Koura", 2.0f),
            Pair("Lebanon", 2.0f),
            Pair("Argentina", 2.0f),
            Pair("Loliput", 2.0f),
            Pair("Albania", 2.0f),
            Pair("Syria", 0.82f)
        )
        assertEquals(expectedList, actualList)
    }

    @Test
    fun ` should throws exception when has a limit less than zero `() {
        // Given limit less than zero
        val limit = -1
        // When no data
        val noData = Executable { testingData.execute(limit) }
        // Then should Throw Exception
        assertThrows(Exception::class.java, noData)
    }

    @Test
    fun `should return correct data list when has limit with correct data and null data`() {
        //Given four countries as a limit and set mockk data
        val limit = 4
        val mockCountry = listOf(
            createMockCity("Cuba",true, 3.0f),
            createMockCity("Egypt", true, 2.0f),
            createMockCity("Koura", true, 3.0f),
            createMockCity("Lebanon", true, 1.0f),
            createMockCity("Argentina",true, .02f),
            createMockCity("Loliput", true, .02f),
            createMockCity("Albania",true, .02f),
            createMockCity("Syria", true,  4.4f)
        )

        every { dataSource.getAllCitiesData() } returns mockCountry
        // When getting result
        val actualList = testingData.execute(limit)
        // Then return listOf Pair(country name and the average prices for those drinks for this country)
        val expectedList = listOf(
            Pair("Syria", 4.4f),
            Pair("Cuba", 3.0f),
            Pair("Koura", 3.0f),
            Pair("Egypt", 2.0f)
        )
        assertEquals(expectedList, actualList)
    }


    @Test
    fun `should return empty list when has a low data quality`() {
        //Given eight countries as a limit and set mockk data
        val limit = 8
        val mockCountry = listOf(
            createMockCity("Cuba", false, 3.0f),
            createMockCity("Egypt", false, 2.0f),
            createMockCity("Koura", false, 7.0f),
            createMockCity("Lebanon", false, 3.50f),
            createMockCity("Argentina", false, 2.0f),
            createMockCity("Loliput", false, 5.0f),
            createMockCity("Albania", false, 6.0f),
            createMockCity("Syria", false, 0.82f)
        )

        every { dataSource.getAllCitiesData() } returns mockCountry
        // When getting result
        val actualList = testingData.execute(limit)
        // Then return empty list
        assertEquals(emptyList(), actualList)
    }


}