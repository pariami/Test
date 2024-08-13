package msi.paria.annicfood.domain.repository

import msi.paria.annicfood.domain.model.Favorite
import msi.paria.annicfood.domain.model.Food

interface FavoriteRepository {
    suspend fun addFavorite(favorite: Favorite)
    suspend fun removeFavorite(favorite: Favorite)
    suspend fun getFavoritesForPerson(personId: Long): List<Food>
}