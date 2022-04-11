package android.example.flowerschemistry.data.models

import java.io.Serializable

data class Florist(
    val id: Int,
    val image: String,
    val name: String,
    val password: String,
    val phoneNumber: String,
    val role: String,
    val salary: Int,
    val status: String,
    val surname: String,
    val workShift: String
): Serializable