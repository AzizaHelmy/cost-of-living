package interactor

import io.mockk.*
import mockData.MockCityEntity.createMockCity
import model.CityEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetCityHasMostSuitableFitnessClubInteractorTest {

    private lateinit var classUnderTest: GetCityHasMostSuitableFitnessClubInteractor
    private var mockData = mockk<CostOfLivingDataSource>()

    @BeforeAll
    fun setUp() {
        clearAllMocks()
        unmockkAll()
        classUnderTest = GetCityHasMostSuitableFitnessClubInteractor(mockData)
    }

    @Test
    fun `should return true when the data quality is high`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "London",
            15.0F,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        //when check if the data quality is true
        val cityResult = classUnderTest.excludeLowQualityData(mockCity)
        //then
        assertTrue(cityResult)
    }

    @Test
    fun `should return false when the data quality is low`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "London",
            15.0F,
            false
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        //when check if the data quality is true
        val cityResult = classUnderTest.excludeLowQualityData(mockCity)
        //then
        assertFalse(cityResult)
    }

    @Test
    fun `should return true when the city is in United Kingdom`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "London",
            15.0F,
            false
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when return true if the country of the city is United Kingdom
        val result = classUnderTest.isCitiesInUnitedKingdomGermanyAndFrance(mockCity)
        // then
        assertTrue(result)
    }

    @Test
    fun `should return true when the city is in Germany`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "Germany",
            "Berlin",
            15.0F,
            false
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when return true if the country of the city is Germany
        val result = classUnderTest.isCitiesInUnitedKingdomGermanyAndFrance(mockCity)
        // then
        assertTrue(result)
    }

    @Test
    fun `should return true when the city is in France`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "France",
            "Paris",
            15.0F,
            false
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when return true if the country of the city is France
        val result = classUnderTest.isCitiesInUnitedKingdomGermanyAndFrance(mockCity)
        // then
        assertTrue(result)
    }
}