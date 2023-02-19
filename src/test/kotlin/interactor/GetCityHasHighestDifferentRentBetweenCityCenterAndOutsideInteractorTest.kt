package interactor

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import mockdata.MockCityEntity.createMockCity
import model.CityEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class GetCityHasHighestDifferentRentBetweenCityCenterAndOutsideInteractorTest {

    private lateinit var highestDifferentRent: GetCityHasHighestDifferentRentBetweenCityCenterAndOutsideInteractor
    private var mockkData = mockk<CostOfLivingDataSource>()

    @BeforeAll
    fun setUp() {
        clearAllMocks()
        unmockkAll()

        highestDifferentRent = GetCityHasHighestDifferentRentBetweenCityCenterAndOutsideInteractor(mockkData)
    }

    @Test
    fun `should ReturnCorrectCity When EnterListOfCityEntities`() {
        //given list of cityEntities
        val citiesData = listOf(
            createMockCity(
                2.5f, 3.0f,
                3.4f, 3.8f, true
            ),
            createMockCity(
                2.5f, 3.0f,
                3.6f, 3.8f, true
            ),
            createMockCity(
                2.8f, 3.0f,
                3.4f, 3.6f, true
            ),
            createMockCity(
                2.7f, 3.0f,
                3.4f, 3.8f, true
            )
        )
        //when find the city with the Highest different rent
        every { mockkData.getAllCitiesData() } returns citiesData
        val city = highestDifferentRent.execute()
        //then
        assertEquals(citiesData[0], city)
    }

    @Test
    fun `should Return excludeLowQualityData When EnterListOfCityEntities`() {
        //given list of cityEntities
        val citiesData = listOf(
            createMockCity(
                2.5f, 3.0f,
                3.4f, 3.8f, false
            ),
            createMockCity(
                2.5f, 3.0f,
                3.6f, 3.8f, false
            ),
            createMockCity(
                2.8f, 3.0f,
                3.4f, 3.6f, false
            ),
            createMockCity(
                2.7f, 3.0f,
                3.4f, 3.8f, true
            )
        )

        //when find the city with the Highest different rent
        every { mockkData.getAllCitiesData() } returns citiesData
        val city = highestDifferentRent.execute()
        //then
        assertEquals(citiesData[3], city)
    }

    @Test
    fun `should throwException When all cities excluded`() {
        //given list of cityEntities
        val citiesData = listOf(
            createMockCity(
                null, null,
                null, null, false
            ),
            createMockCity(
                null, null,
                null, null, false
            ),
        )
        //when find the city with the Highest different rent
        every { mockkData.getAllCitiesData() } returns citiesData
        val city = Executable { highestDifferentRent.execute() }

        //then
        assertThrows(Exception::class.java, city)
    }
    @Test
    fun `should throwException When all cities rent is null`() {
        //given list of cityEntities
        val citiesData = listOf(
            createMockCity(
                null, null,
                null, null, true
            ),
            createMockCity(
                null, null,
                null, null, true
            ),
        )
        //when find the city with the Highest different rent
        every { mockkData.getAllCitiesData() } returns citiesData
        val city = Executable { highestDifferentRent.execute() }

        //then
        assertThrows(Exception::class.java, city)
    }

    @Test
    fun `should throwException When the list of cities is empty`() {
        //given an empty list of cityEntities
        val citiesData = emptyList<CityEntity>()
        //when find the city with the Highest different rent
        every { mockkData.getAllCitiesData() } returns citiesData
        val city = Executable { highestDifferentRent.execute() }

        //then
        assertThrows(Exception::class.java, city)
    }


}