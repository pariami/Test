package msi.paria.annicfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import msi.paria.annicfood.domain.model.Favorite
import msi.paria.annicfood.domain.model.Food
import msi.paria.annicfood.domain.model.Person
import msi.paria.annicfood.domain.usecase.AddFavoriteUseCase
import msi.paria.annicfood.domain.usecase.AddFoodUseCase
import msi.paria.annicfood.domain.usecase.AddPersonUseCase
import msi.paria.annicfood.domain.usecase.GetAllFoodsUseCase
import msi.paria.annicfood.domain.usecase.GetAllPersonsUseCase
import msi.paria.annicfood.domain.usecase.GetFavoritesForPersonUseCase
import msi.paria.annicfood.domain.usecase.RemoveFavoriteUseCase
import msi.paria.annicfood.util.Screen
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val addPersonUseCase: AddPersonUseCase,
    private val getAllPersonsUseCase: GetAllPersonsUseCase,
    private val addFoodUseCase: AddFoodUseCase,
    private val getAllFoodsUseCase: GetAllFoodsUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val getFavoritesForPersonUseCase: GetFavoritesForPersonUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
) : ViewModel() {

    private val _persons = MutableStateFlow<List<Person>>(emptyList())
    val persons: StateFlow<List<Person>> = _persons

    private val _foods = MutableStateFlow<List<Food>>(emptyList())
    val foods: StateFlow<List<Food>> = _foods

    private val _selectedPerson = MutableStateFlow<Person?>(null)
    val selectedPerson: StateFlow<Person?> = _selectedPerson

    private val _favorites = MutableStateFlow<List<Food>>(emptyList())
    val favorites: StateFlow<List<Food>> = _favorites

    private val _currentScreen = MutableStateFlow<Screen>(Screen.PersonList)
    val currentScreen: StateFlow<Screen> = _currentScreen

    init {
        loadPersons()
        loadFoods()
    }

    fun addPerson(name: String) {
        viewModelScope.launch {
            addPersonUseCase.execute(Person(name = name))
            loadPersons()
        }
    }

    fun loadPersons() {
        viewModelScope.launch {
            _persons.value = getAllPersonsUseCase.execute()
        }
    }

    fun addFood(name: String) {
        viewModelScope.launch {
            addFoodUseCase.execute(Food(name = name))
            loadFoods()
        }
    }

    fun loadFoods() {
        viewModelScope.launch {
            _foods.value = getAllFoodsUseCase.execute()
        }
    }

    fun loadFavorites(personId: Long) {
        viewModelScope.launch {
            _favorites.value = getFavoritesForPersonUseCase.execute(personId)
        }
    }

    fun addFavorite(foodId: Long) {
        _selectedPerson.value?.let { person ->
            viewModelScope.launch {
                addFavoriteUseCase.execute(Favorite(person.id, foodId))
                loadFavorites(person.id)
            }
        }
    }

    fun removeFavorite(foodId: Long) {
        _selectedPerson.value?.let { person ->
            viewModelScope.launch {
                removeFavoriteUseCase.execute(Favorite(person.id, foodId))
                loadFavorites(person.id)
            }
        }
    }
    fun navigateToFoodFavoritesScreen(person: Person) {
        _selectedPerson.value = person
        loadFavorites(person.id)
        _currentScreen.value = Screen.FoodFavorites
    }

    fun navigateToPersonListScreen() {
        _currentScreen.value = Screen.PersonList
    }
}
