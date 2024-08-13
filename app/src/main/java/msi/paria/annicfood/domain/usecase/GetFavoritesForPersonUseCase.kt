package msi.paria.annicfood.domain.usecase

import msi.paria.annicfood.domain.model.Food
import msi.paria.annicfood.domain.repository.FavoriteRepository
import javax.inject.Inject

class GetFavoritesForPersonUseCase @Inject constructor(private val favoriteRepository: FavoriteRepository) {
    suspend fun execute(personId: Long): List<Food> = favoriteRepository.getFavoritesForPerson(personId)
}