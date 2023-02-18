package interactor

import io.mockk.clearAllMocks
import io.mockk.mockk
import io.mockk.unmockkAll

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetCityHasCheapestDressPriceTest {
    private lateinit var interactor: GetCityHasCheapestDressPriceInteractor
    private val mockData = mockk<CostOfLivingDataSource>()


    @BeforeAll
    fun setup() {
        unmockkAll()
        clearAllMocks()
        interactor = GetCityHasCheapestDressPriceInteractor(mockData)
    }


}