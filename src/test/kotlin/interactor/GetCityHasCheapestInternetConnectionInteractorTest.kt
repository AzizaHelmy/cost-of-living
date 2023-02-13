package interactor

import fakeData.FakeData
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetCityHasCheapestInternetConnectionInteractorTest {

    private lateinit var fakedata: FakeData
    private lateinit var getCityHasCheapestInternetConnection: GetCityHasCheapestInternetConnectionInteractor

    @BeforeAll
    fun setUp() {
        fakedata = FakeData()
        getCityHasCheapestInternetConnection = GetCityHasCheapestInternetConnectionInteractor(fakedata)
    }
    @Test
    fun `should return cheapest city When enter list of cities`() {
        // given
        // when
        val city = getCityHasCheapestInternetConnection.execute()
        // then
        assertEquals(fakedata.getAllCitiesData()[10], city)
    }


}