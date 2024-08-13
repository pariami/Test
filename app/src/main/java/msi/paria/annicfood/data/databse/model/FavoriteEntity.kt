package msi.paria.annicfood.data.databse.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "favorites",
    primaryKeys = ["personId", "foodId"],
    foreignKeys = [
        ForeignKey(entity = PersonEntity::class, parentColumns = ["id"], childColumns = ["personId"]),
        ForeignKey(entity = FoodEntity::class, parentColumns = ["id"], childColumns = ["foodId"])
    ]
)
data class FavoriteEntity(
    val personId: Long,
    val foodId: Long
)