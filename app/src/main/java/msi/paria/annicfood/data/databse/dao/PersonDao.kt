package msi.paria.annicfood.data.databse.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import msi.paria.annicfood.data.databse.model.PersonEntity

@Dao
interface PersonDao {
    @Insert
    suspend fun insertPerson(person: PersonEntity)

    @Query("SELECT * FROM persons")
    suspend fun getAllPersons(): List<PersonEntity>
}