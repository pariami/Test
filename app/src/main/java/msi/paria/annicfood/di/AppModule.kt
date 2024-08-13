package msi.paria.annicfood.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import msi.paria.annicfood.data.databse.AppDatabase
import msi.paria.annicfood.data.databse.dao.FavoriteDao
import msi.paria.annicfood.data.databse.dao.FoodDao
import msi.paria.annicfood.data.databse.dao.PersonDao
import msi.paria.annicfood.data.repository.FavoriteRepositoryImpl
import msi.paria.annicfood.data.repository.FoodRepositoryImpl
import msi.paria.annicfood.data.repository.PersonRepositoryImpl
import msi.paria.annicfood.domain.repository.FavoriteRepository
import msi.paria.annicfood.domain.repository.FoodRepository
import msi.paria.annicfood.domain.repository.PersonRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePersonRepository(personDao: PersonDao): PersonRepository {
        return PersonRepositoryImpl(personDao)
    }

    @Provides
    @Singleton
    fun provideFoodRepository(foodDao: FoodDao): FoodRepository {
        return FoodRepositoryImpl(foodDao)
    }

    @Provides
    @Singleton
    fun provideFavoriteRepository(favoriteDao: FavoriteDao): FavoriteRepository {
        return FavoriteRepositoryImpl(favoriteDao)
    }

    @Provides
    @Singleton
    fun provideDatabase( @ApplicationContext  context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun providePersonDao(db: AppDatabase): PersonDao = db.personDao()

    @Provides
    fun provideFoodDao(db: AppDatabase): FoodDao = db.foodDao()

    @Provides
    fun provideFavoriteDao(db: AppDatabase): FavoriteDao = db.favoriteDao()

}