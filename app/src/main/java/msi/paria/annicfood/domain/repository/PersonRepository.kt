package msi.paria.annicfood.domain.repository

import msi.paria.annicfood.domain.model.Person

interface PersonRepository {
    suspend fun addPerson(person: Person)
    suspend fun getAllPersons(): List<Person>
}