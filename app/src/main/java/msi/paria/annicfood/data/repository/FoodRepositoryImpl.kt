package msi.paria.annicfood.data.repository

import msi.paria.annicfood.data.databse.dao.FoodDao
import msi.paria.annicfood.data.databse.model.FoodEntity
import msi.paria.annicfood.domain.model.Food
import msi.paria.annicfood.domain.repository.FoodRepository

class FoodRepositoryImpl(private val foodDao: FoodDao) : FoodRepository {
    override suspend fun addFood(food: Food) {
        foodDao.insertFood(FoodEntity(name = food.name))
    }

    override suspend fun getAllFoods(): List<Food> {
        return foodDao.getAllFoods().map { Food(it.id, it.name) }
    }
}