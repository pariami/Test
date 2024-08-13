package msi.paria.annicfood.data.databse.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import msi.paria.annicfood.data.databse.model.FavoriteEntity
import msi.paria.annicfood.data.databse.model.FoodEntity

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: FavoriteEntity)

    @Delete
    suspend fun deleteFavorite(favorite: FavoriteEntity)

    @Query("""
        SELECT foods.* FROM foods 
        INNER JOIN favorites ON foods.id = favorites.foodId 
        WHERE favorites.personId = :personId
    """)
    suspend fun getFavoritesForPerson(personId: Long): List<FoodEntity>
}