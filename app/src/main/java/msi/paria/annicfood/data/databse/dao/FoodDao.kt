package msi.paria.annicfood.data.databse.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import msi.paria.annicfood.data.databse.model.FoodEntity

@Dao
interface FoodDao {
    @Insert
    suspend fun insertFood(food: FoodEntity)

    @Query("SELECT * FROM foods")
    suspend fun getAllFoods(): List<FoodEntity>
}