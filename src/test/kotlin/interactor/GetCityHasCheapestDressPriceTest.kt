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


        }

