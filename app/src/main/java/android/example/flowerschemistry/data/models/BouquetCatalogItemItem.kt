package android.example.flowerschemistry.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "cart_bouquets")
data class BouquetCatalogItemItem(
    val category: Category,
    @PrimaryKey(autoGenerate = true)
    val cost: Int,
    val date: String,
    val dateExp: String,
    val description: String,
    val filial: Filial,
    val florist: Florist,
    val flowers: List<Any>,
    val id: Int,
    val image: String,
    val name: String,
    val selection: String,
    val status: String
): Serializable