package android.example.flowerschemistry.data.models

import java.io.Serializable

data class Flower(
    val category: Category,
    val cost: Int,
    val date: String,
    val description: String,
    val grade: String,
    val id: Int,
    val image: String,
    val name: String,
    val quantity: Int,
    val shortDescription: String
)