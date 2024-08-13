package msi.paria.annicfood.domain.usecase

import msi.paria.annicfood.domain.model.Person
import msi.paria.annicfood.domain.repository.PersonRepository
import javax.inject.Inject

class AddPersonUseCase @Inject constructor(private val personRepository: PersonRepository) {
    suspend fun execute(person: Person) = personRepository.addPerson(person)
}