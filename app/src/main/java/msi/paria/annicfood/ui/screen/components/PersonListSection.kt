package msi.paria.annicfood.ui.screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import msi.paria.annicfood.domain.model.Person

@Composable
fun PersonListSection(
    persons: List<Person>,
    onPersonClick: (Person) -> Unit,
    onAddPerson: (String) -> Unit,
    onAddFood: (String) -> Unit
) {
    Column {
        Text("Persons List")

        LazyColumn {
            items(persons) { person ->
                Text(
                    text = person.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onPersonClick(person) }
                        .padding(8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        var personName by remember { mutableStateOf("") }
        OutlinedTextField(
            value = personName,
            onValueChange = { personName = it },
            label = { Text("Add Person") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = { onAddPerson(personName) }) {
            Text("Add Person")
        }

        Spacer(modifier = Modifier.height(16.dp))

        var foodName by remember { mutableStateOf("") }
        OutlinedTextField(
            value = foodName,
            onValueChange = { foodName = it },
            label = { Text("Add Food") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = { onAddFood(foodName) }) {
            Text("Add Food")
        }
    }
}
