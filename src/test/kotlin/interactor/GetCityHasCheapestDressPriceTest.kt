package interactor

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import mockdata.MockCityEntity
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetCityHasCheapestDressPriceTest {
    private lateinit var getCityHasCheapestDressPrice: GetCityHasCheapestDressPrice
    private val mockData = mockk<CostOfLivingDataSource>()


    @BeforeAll
    fun setup() {
        unmockkAll()
        clearAllMocks()
        getCityHasCheapestDressPrice = GetCityHasCheapestDressPrice(mockData)
    }

    @Test
    fun `should return both city name and dress price when country name is correct`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity("Egypt","Cairo",true,100f)
            ,MockCityEntity.createMockCity("Egypt","Giza",true,70f))
        // When
        every { mockData.getAllCitiesData() } returns (mockCity)
        // Then
        val actualResult = getCityHasCheapestDressPrice.execute("Egypt")
        assertEquals(listOf(Pair("Giza", 70f)), actualResult)
    }
    @Test
    fun `should throws exception when country name is incorrect or empty`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity("Eypy","Cairo",true,100f)
            ,MockCityEntity.createMockCity("Egypy","Giza",true,70f))
        // When
        every { mockData.getAllCitiesData() } returns (mockCity)
        // Then
        val actualResult = Executable { getCityHasCheapestDressPrice.execute("") }
        assertThrows(Exception::class.java, actualResult)
    }

    @Test
    fun `should return false when low data quality`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity("Egypt","Cairo",false,100f))
        // When
        every { mockData.getAllCitiesData() } returns (mockCity)
        // Then
        val actualResult = getCityHasCheapestDressPrice.excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(mockCity[0],"Egypt")
        assertFalse(actualResult)
    }

    @Test
    fun `should return false when dress price is null`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity("Egypt","Giza",true,null)
        )
        // When
        every { mockData.getAllCitiesData() } returns (mockCity)
        // Then
        val actualResult =  getCityHasCheapestDressPrice.excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(mockCity[0],"Egypt")
        assertFalse(actualResult)
    }
    @Test
    fun `should return false when country name is incorrect or null`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity("Egypt","Giza",true,100f)
        )
        // When
        every { mockData.getAllCitiesData() } returns (mockCity)
        // Then
        val actualResult =  getCityHasCheapestDressPrice.excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(mockCity[0],"laB laB laB")
        assertFalse(actualResult)
    }
    @Test
    fun `should return true when all country name ,dress price is correct and quality data is high`() {
        // Given
        val mockCity = listOf(MockCityEntity.createMockCity("Egypt","Giza",true,100f)
        )
        // When
        every { mockData.getAllCitiesData() } returns (mockCity)
        // Then
        val actualResult =  getCityHasCheapestDressPrice.excludeNullDressPriceAndCitiesOutCountryAndLowQualityData(mockCity[0],"Egypt")
        assertTrue(actualResult)
    }

}

