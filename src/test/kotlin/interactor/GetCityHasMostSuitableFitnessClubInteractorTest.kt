package interactor

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import mockdata.MockCityEntity.createMockCity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetCityHasMostSuitableFitnessClubInteractorTest {

    private lateinit var interactor: GetCityHasMostSuitableFitnessClubInteractor
    private val mockData = mockk<CostOfLivingDataSource>()

    @BeforeAll
    fun setUp() {
        clearAllMocks()
        unmockkAll()
        interactor = GetCityHasMostSuitableFitnessClubInteractor(mockData)
    }

    @Test
    fun `should return true when the data quality is high`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "London",
            300.0F,
            15.0F,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        //when check if the data quality is true
        val cityResult = interactor.excludeLowQualityData(mockCity)
        //then
        assertTrue(cityResult)
    }

    @Test
    fun `should return false when the data quality is low`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "Manchester",
            200.0F,
            10.0F,
            false
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        //when check if the data quality is true
        val cityResult = interactor.excludeLowQualityData(mockCity)
        //then
        assertFalse(cityResult)
    }

    @Test
    fun `should return true when the city is in United Kingdom`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "London",
            300.0F,
            15.0F,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when return true if the country of the city is United Kingdom
        val result = interactor.isCitiesInUnitedKingdomGermanyAndFrance(mockCity)
        // then
        assertTrue(result)
    }

    @Test
    fun `should return true when the city is in Germany`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "Germany",
            "Berlin",
            400.0F,
            30.0F,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when return true if the country of the city is Germany
        val result = interactor.isCitiesInUnitedKingdomGermanyAndFrance(mockCity)
        // then
        assertTrue(result)
    }

    @Test
    fun `should return true when the city is in France`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "France",
            "Paris",
            250.0F,
            12.0F,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when return true if the country of the city is France
        val result = interactor.isCitiesInUnitedKingdomGermanyAndFrance(mockCity)
        // then
        assertTrue(result)
    }

    @Test
    fun `should return false when the city is in Spain`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "Spain",
            "Madrid",
            160.0F,
            35.0F,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when return true if the country of the city is Spain
        val result = interactor.isCitiesInUnitedKingdomGermanyAndFrance(mockCity)
        // then
        assertFalse(result)
    }

    @Test
    fun `should return value when the city has one way ticket`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "London",
            300.0F,
            15.0F,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        //when check if city has one way ticket
        val cityResult = interactor.isCityHasPriceOfTransportationOfOneWayTicket(mockCity)
        //then
        assertNotNull(cityResult)
    }

    @Test
    fun `should return null when the city hasn't one way ticket`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "London",
            300.0F,
            null,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        //when check if city has not one way ticket
        val cityResult = interactor.isCityHasPriceOfTransportationOfOneWayTicket(mockCity)
        //then
        assertNull(cityResult)
    }

    @Test
    fun `should return true when the city has fitness club monthly fee for one adult`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "London",
            300.0F,
            15.0F,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        //when check if the city has fitness club monthly fee for one adult
        val cityResult = interactor.isCityHasFitnessClubMonthlyFeeForOneAdult(mockCity)
        //then
        assertTrue(cityResult)
    }

    @Test
    fun `should return false when the city hasn't fitness club monthly fee for one adult`() {
        // given mock city entity data and the expected value
        val mockCity = createMockCity(
            "United Kingdom",
            "London",
            null,
            15.0F,
            true
        )
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        //when check if the city has no fitness club monthly fee for one adult
        val cityResult = interactor.isCityHasFitnessClubMonthlyFeeForOneAdult(mockCity)
        //then
        assertFalse(cityResult)
    }

    @Test
    fun `should throw exception when the limit is negative`() {
        // given limit is negative
        val negativeLimit = -2
        //when execute function throw exception
        val executeResult = Executable { interactor.execute(limit = negativeLimit) }
        //then
        assertThrows(Throwable::class.java, executeResult)
    }
}