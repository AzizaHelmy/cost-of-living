package interactor

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import mockdata.MockCityEntity.createMockCity
import model.CityEntity
import model.MealsPrices
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetCityHasAverageMealPricesInteractorTest {

    private lateinit var interactor: GetCityHasAverageMealPricesInteractor
    private var mockData = mockk<CostOfLivingDataSource>()

    @BeforeAll
    fun setUp() {
        clearAllMocks()
        unmockkAll()
        interactor = GetCityHasAverageMealPricesInteractor(mockData)
    }

    @Test
    fun `should return true when the city is in USA`() {
        // given fake city entity data
        val city: CityEntity = mockk()
        // when return the country of the city is USA
        every { city.country } returns ThreeSpecificCountries.USA.nameOFCountry
        val result = interactor.isCitiesInUSACanadaAndMexico(city)
        // then
        assertTrue(result)
    }

    @Test
    fun `should return true when the city is in Canada`() {
        // given fake city entity data
        val city: CityEntity = mockk()
        // when return the country of the city is Canada
        every { city.country } returns ThreeSpecificCountries.CANADA.nameOFCountry
        val result = interactor.isCitiesInUSACanadaAndMexico(city)
        // then
        assertTrue(result)
    }

    @Test
    fun `should return true when the city is in Mexico`() {
        // given fake city entity data
        val city: CityEntity = mockk()
        // when return the country of the city is Mexico
        every { city.country } returns ThreeSpecificCountries.MEXICO.nameOFCountry
        val result = interactor.isCitiesInUSACanadaAndMexico(city)
        // then
        assertTrue(result)
    }

    @Test
    fun `should return false when the city is in Egypt`() {
        // given fake city entity data
        val city: CityEntity = mockk()
        // when return the country of the city is Egypt
        every { city.country } returns ThreeSpecificCountries.EGYPT.nameOFCountry
        val result = interactor.isCitiesInUSACanadaAndMexico(city)
        // then
        assertFalse(result)
    }

    @Test
    fun `should return false when the city has no averageMeal price and InexpensiveMeal`() {
        // given mealFor2PeopleMidRangeRestaurant , mealInexpensiveRestaurant is null
        val mealPrices = MealsPrices(null, null, 4.0F)
        val mockCity = createMockCity("Mexico", "Mexico",mealPrices)
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when check if city has average meal
        val result = interactor.excludeNullMealPrices(mockCity)
        // then
        assertEquals(false, result)
    }

    @Test
    fun `should return false when the city has no averageMeal price and Expensive`() {
        // given mealFor2PeopleMidRangeRestaurant , mealAtMcDonaldSOrEquivalent is null
        val mealPrices = MealsPrices(4.0F, null, null)
        val mockCity = createMockCity("Mexico", "Mexico",mealPrices)
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when check if city has average meal
        val result = interactor.excludeNullMealPrices(mockCity)
        // then
        assertEquals(false, result)
    }

    @Test
    fun `should return true when the city has AverageMeal`() {
        // given all mealPrices data
        val mealPrices = MealsPrices(2.0F, 6.0F, 6.0F)
        val mockCity = createMockCity("Mexico", "Mexico",mealPrices)
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when check if city has average meal
        val result = interactor.excludeNullMealPrices(mockCity)
        // then
        assertEquals(true, result)
    }

    @Test
    fun `should return true when the city has InexpensiveMeal and ExpensiveMeal`() {
        // given mealFor2PeopleMidRangeRestaurant is null
        val mealPrices = MealsPrices(6.0F, null, 2.0F)
        val mockCity = createMockCity("Mexico", "Mexico",mealPrices)
        every { mockData.getAllCitiesData() } returns listOf(mockCity)
        // when check if city has average meal
        val result = interactor.excludeNullMealPrices(mockCity)
        // then
        assertEquals(true, result)
    }

    @Test
    fun `should return city entity when cities list is not empty`() {
        // given mock city entity data and the expected value
        val mealPrices = MealsPrices(
            27.0F,
            93.0F,
            8.75F
        )
        val mealPrices2 = MealsPrices(
            9.0F,
            175.0F,
            5.5F
        )
        val mealPrices3 = MealsPrices(
            4.0F,
            null,
            7.0F
        )
        val cityEntityList = listOf(
            createMockCity("United States", "Collingswood", mealPrices),
            createMockCity("Mexico", "Mexico", mealPrices2),
            createMockCity("Canada", "Canada", mealPrices3)
        )
        every { mockData.getAllCitiesData() } returns cityEntityList
        // when list is not empty
        val cityResult = interactor.execute()
        // then
        assertEquals(cityEntityList[0], cityResult)
    }
}