package model

data class MealsPrices(
    val mealInexpensiveRestaurant: Float?,
    val mealFor2PeopleMidRangeRestaurant: Float?,
    val mealAtMcDonaldSOrEquivalent: Float?,
) {
    fun getAverageMealInCity(city: CityEntity): Float? {
        city.mealsPrices.run {
            return if (mealFor2PeopleMidRangeRestaurant != null) {
                mealFor2PeopleMidRangeRestaurant / 2
            } else if ((mealInexpensiveRestaurant != null) && (mealAtMcDonaldSOrEquivalent != null))
                ((mealInexpensiveRestaurant) + (mealAtMcDonaldSOrEquivalent)) / 2
            else null
        }

    }
}