package interactor

import io.mockk.*
import mockData.MockCityEntity.createMockCity
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
}