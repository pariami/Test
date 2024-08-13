package msi.paria.annicfood.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import msi.paria.annicfood.ui.viewmodel.PersonViewModel

@Composable
fun FoodFavoritesScreen(personViewModel: PersonViewModel) {
    val selectedPerson by personViewModel.selectedPerson.collectAsState()
    val foods by personViewModel.foods.collectAsState()
    val favorites by personViewModel.favorites.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        selectedPerson?.let { person ->
            Text("${person.name}'s Favorite Foods")

            LazyColumn {
                items(favorites) { food ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(text = food.name, modifier = Modifier.weight(1f))
                        IconButton(onClick = { personViewModel.removeFavorite(food.id) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Remove Favorite")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Add to Favorites")
            LazyColumn {
                items(foods) { food ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(text = food.name, modifier = Modifier.weight(1f))
                        IconButton(onClick = { personViewModel.addFavorite(food.id) }) {
                            Icon(Icons.Default.Add, contentDescription = "Add to Favorite")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { personViewModel.navigateToPersonListScreen() }) {
                Text("Back to Person List")
            }
        }
    }
}