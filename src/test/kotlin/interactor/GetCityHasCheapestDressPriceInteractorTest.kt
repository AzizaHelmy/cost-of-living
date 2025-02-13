package interactor

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import mockdata.MockCityEntity
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetCityHasCheapestDressPriceInteractorTest {

    private lateinit var interactor: GetCityHasCheapestDressPriceInteractor
    private val mockData = mockk<CostOfLivingDataSource>()

    @BeforeAll
    fun setup() {
        unmockkAll()
        clearAllMocks()
        interactor = GetCityHasCheapestDressPriceInteractor(mockData)
    }

    @Test
    fun `should return both city name and dress price when country name is correct`() {
        // Given
        val mockCity = listOf(
            MockCityEntity.createMockCity(
                "Egypt",
                "Cairo",
                true,
                100f),
            MockCityEntity.createMockCity(
                "Egypt",
                "Giza",
                true,
                70f)
        )
        every { mockData.getAllCitiesData() } returns (mockCity)
        // When
        val actualResult = interactor.execute(2, "Egypt")
        // Then
        assertEquals(listOf(Pair("Giza", 70f), Pair("Cairo", 100f)), actualResult)
    }

    @Test
    fun `should throws exception when country name is incorrect or empty`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity(
            "Eypy",
            "Cairo",
            true,
            100f))
        every { mockData.getAllCitiesData() } returns (mockCity)
        // When
        val actualResult = Executable { interactor.execute(1, "") }
        // Then
        assertThrows(Exception::class.java, actualResult)
    }

    @Test
    fun `should return false when low data quality`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity(
            "Egypt",
            "Cairo",
            false,
            100f))
        every { mockData.getAllCitiesData() } returns (mockCity)
        // When
        val actualResult = interactor.excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(mockCity[0], "Egypt")
        // Then
        assertFalse(actualResult)
    }

    @Test
    fun `should return false when dress price is null`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity(
            "Egypt",
            "Giza",
            true,
            null))
        every { mockData.getAllCitiesData() } returns (mockCity)
        // When
        val actualResult = interactor.excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(mockCity[0], "Egypt")
        //Then
        assertFalse(actualResult)
    }

    @Test
    fun `should return false when country name is incorrect or null`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity(
            "Egypt",
            "Giza",
            true,
            100f))
        every { mockData.getAllCitiesData() } returns (mockCity)
        // When
        val actualResult =
            interactor.excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(mockCity[0], "lab lab lab")
        //Then
        assertFalse(actualResult)
    }

    @Test
    fun `should return true when all country name ,dress price is correct and quality data is high`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity(
            "Egypt",
            "Giza",
            true,
            100f))
        every { mockData.getAllCitiesData() } returns (mockCity)
        // When
        val actualResult = interactor.excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(mockCity[0], "Egypt")
        // Then
        assertTrue(actualResult)
    }
}