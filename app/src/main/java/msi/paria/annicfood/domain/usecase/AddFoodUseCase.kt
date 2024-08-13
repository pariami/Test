package msi.paria.annicfood.domain.usecase

import msi.paria.annicfood.domain.model.Food
import msi.paria.annicfood.domain.repository.FoodRepository
import javax.inject.Inject

class AddFoodUseCase @Inject constructor(private val foodRepository: FoodRepository) {
    suspend fun execute(food: Food) = foodRepository.addFood(food)
}