package android.example.flowerschemistry.data.models

import java.io.Serializable

data class BouquetSelectionItem(
    val category: Category,
    val cost: Int,
    val date: String,
    val dateExp: String,
    val description: String,
    val filial: Filial,
    val florist: Florist,
    val flowers: List<Flower>,
    val id: Int,
    val image: String,
    val name: String,
    val selection: String,
    val status: String
): Serializable