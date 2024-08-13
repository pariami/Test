package msi.paria.annicfood.domain.usecase

import msi.paria.annicfood.domain.model.Favorite
import msi.paria.annicfood.domain.repository.FavoriteRepository
import javax.inject.Inject

class RemoveFavoriteUseCase @Inject constructor(private val favoriteRepository: FavoriteRepository) {
    suspend fun execute(favorite: Favorite) = favoriteRepository.removeFavorite(favorite)
}
