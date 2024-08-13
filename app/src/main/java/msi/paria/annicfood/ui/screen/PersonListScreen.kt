package msi.paria.annicfood.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import msi.paria.annicfood.ui.screen.components.PersonListSection
import msi.paria.annicfood.ui.viewmodel.PersonViewModel

@Composable
fun PersonListScreen(personViewModel: PersonViewModel) {
    val persons by personViewModel.persons.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        PersonListSection(
            persons = persons,
            onPersonClick = { personViewModel.navigateToFoodFavoritesScreen(it) },
            onAddPerson = { personViewModel.addPerson(it) },
            onAddFood = { personViewModel.addFood(it) }
        )
    }
}