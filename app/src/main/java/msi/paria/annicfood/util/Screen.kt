package msi.paria.annicfood.util

sealed class Screen {
    object PersonList : Screen()
    object FoodFavorites : Screen()
}