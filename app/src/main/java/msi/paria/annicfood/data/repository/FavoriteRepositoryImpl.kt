package msi.paria.annicfood.data.repository

import msi.paria.annicfood.data.databse.dao.FavoriteDao
import msi.paria.annicfood.data.databse.model.FavoriteEntity
import msi.paria.annicfood.domain.model.Favorite
import msi.paria.annicfood.domain.model.Food
import msi.paria.annicfood.domain.repository.FavoriteRepository

class FavoriteRepositoryImpl(private val favoriteDao: FavoriteDao) : FavoriteRepository {
    override suspend fun addFavorite(favorite: Favorite) {
        favoriteDao.insertFavorite(FavoriteEntity(favorite.personId, favorite.foodId))
    }

    override suspend fun removeFavorite(favorite: Favorite) {
        favoriteDao.deleteFavorite(FavoriteEntity(favorite.personId, favorite.foodId))
    }

    override suspend fun getFavoritesForPerson(personId: Long): List<Food> {
        return favoriteDao.getFavoritesForPerson(personId).map { Food(it.id, it.name) }
    }
}