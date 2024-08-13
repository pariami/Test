package msi.paria.annicfood.data.repository

import msi.paria.annicfood.data.databse.dao.PersonDao
import msi.paria.annicfood.data.databse.model.PersonEntity
import msi.paria.annicfood.domain.model.Person
import msi.paria.annicfood.domain.repository.PersonRepository

class PersonRepositoryImpl(private val personDao: PersonDao) : PersonRepository {
    override suspend fun addPerson(person: Person) {
        personDao.insertPerson(PersonEntity(name = person.name))
    }

    override suspend fun getAllPersons(): List<Person> {
        return personDao.getAllPersons().map { Person(it.id, it.name) }
    }
}