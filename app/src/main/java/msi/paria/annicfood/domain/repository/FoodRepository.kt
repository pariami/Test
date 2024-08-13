package msi.paria.annicfood.domain.repository

import msi.paria.annicfood.domain.model.Food

interface FoodRepository {
    suspend fun addFood(food: Food)
    suspend fun getAllFoods(): List<Food>
}