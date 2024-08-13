package msi.paria.annicfood.data.databse

import androidx.room.Database
import androidx.room.RoomDatabase
import msi.paria.annicfood.data.databse.dao.FavoriteDao
import msi.paria.annicfood.data.databse.dao.FoodDao
import msi.paria.annicfood.data.databse.dao.PersonDao
import msi.paria.annicfood.data.databse.model.FavoriteEntity
import msi.paria.annicfood.data.databse.model.FoodEntity
import msi.paria.annicfood.data.databse.model.PersonEntity

@Database(entities = [PersonEntity::class, FoodEntity::class, FavoriteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun foodDao(): FoodDao
    abstract fun favoriteDao(): FavoriteDao
}
