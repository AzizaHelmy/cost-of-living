package interactor

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import mockData.MockCityEntity
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

/**
 * Created by Rehab Fakhry on Sun, 2/19/2023 at 12:49 AM.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetCityHasCheapestCappuccinoRegularInRestaurantsInteractorTest {

    private val dataSource = mockk<CostOfLivingDataSource>()
    private lateinit var interactor: GetCityHasCheapestCappuccinoRegularInRestaurantsInteractor

    @BeforeAll
    fun setUp (){
        unmockkAll()
        clearAllMocks()
        interactor = GetCityHasCheapestCappuccinoRegularInRestaurantsInteractor(dataSource)
    }

    @Test
    fun `should return city name and cheapest cappuccino regular in restaurants when enter a uppercase country name`(){
        // Given an Uppercase country name
        val mockCity = listOf(
            MockCityEntity.createMockCity(
                cappuccinoRegularInRestaurants =3.34f,
                countryName = "United States",
                cityName = "Amarillo" ,
                dataQuality = true
            ) ) //(Amarillo, 3.34)
        // When Cappuccino Regular price is not null and high dataQuality
        every { dataSource.getAllCitiesData()} returns (mockCity)
        // Then return a list of pair of city name and Cappuccino Regular price
        val result = interactor.execute(mockCity[0].country)
        assertEquals(listOf(Pair("Amarillo", 3.34f)), result)
    }

    @Test
    fun `should return city name and cheapest cappuccino regular in restaurants when enter a lowercase country name`() {
        // Given lowercase country name
         val mockCity = listOf(
            MockCityEntity.createMockCity(
                cappuccinoRegularInRestaurants =3.89f,
                countryName = "french",
                cityName = "Paris" ,
                dataQuality = true
            ) )  //(Paris, 3.89)

        // When Cappuccino Regular price is not null and high dataQuality
        every { dataSource.getAllCitiesData()} returns (mockCity)

        // Then return a list of pair of city name and Cappuccino Regular price
        val actualResult = interactor.execute(mockCity[0].country)
        assertEquals(listOf(Pair("Paris", 3.89f)), actualResult)
    }


    @Test
    fun `should return name of city and cappuccino regular in restaurants when enter a mixed country name `() {
        // Given country name Mix of Uppercase and Lowercase
        val mockCity = listOf(
            MockCityEntity.createMockCity(
                cappuccinoRegularInRestaurants =1.98f,
                countryName = "TuRkey",
                cityName = "Istanbul" ,
                dataQuality = true
            ) )
        //(Istanbul, 1.98)

        every { dataSource.getAllCitiesData() } returns (mockCity)

        // When Cappuccino Regular not null and high dataQuality
        val actualList = interactor.execute(mockCity[0].country)

        // Then return a list of pair of city name and Cappuccino Regular
        assertEquals(listOf(Pair("Istanbul", 1.98f)), actualList)
    }


    @Test
    fun `should return exception when enter an empty country name`() {
        // Given empty country name
        val mockCity = listOf(
        MockCityEntity.createMockCity(
            cappuccinoRegularInRestaurants =1.98f,
            countryName = "",
            cityName = "Istanbul" ,
            dataQuality = true
        ) )

        val exception = IllegalStateException("You entered an empty country name!")
        every { dataSource.getAllCitiesData() } throws (exception)

        // When country name is empty
        val result = Executable { interactor.execute(mockCity[0].country) }

        // Then return Throw Exception
        assertThrows(Exception::class.java, result)
    }


    @Test
    fun `should return false when null cappuccino regular and low quality data`() {
        // Given cityEntity
        val mockCity = listOf(
            MockCityEntity.createMockCity(
                cappuccinoRegularInRestaurants =null,
                countryName = "Turkey",
                cityName = "Istanbul" ,
                dataQuality = false
            ) )

        every { dataSource.getAllCitiesData() } returns (mockCity)

        // When cappuccino regular is not null and high dataQuality
        val Result = interactor.excludeNullCappuccinoRegularInRestaurantsAndLowQualityData(mockCity[0])

        // Then return false
        assertFalse(Result)
    }

}