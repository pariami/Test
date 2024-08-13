package msi.paria.annicfood.ui.screen.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import msi.paria.annicfood.ui.screen.FoodFavoritesScreen
import msi.paria.annicfood.ui.screen.PersonListScreen
import msi.paria.annicfood.util.Screen
import msi.paria.annicfood.ui.viewmodel.PersonViewModel

@Composable
fun AppContent(personViewModel: PersonViewModel) {
    val currentScreen by personViewModel.currentScreen.collectAsState()

    when (currentScreen) {
        is Screen.PersonList -> PersonListScreen(personViewModel)
        is Screen.FoodFavorites -> FoodFavoritesScreen(personViewModel)
    }
}