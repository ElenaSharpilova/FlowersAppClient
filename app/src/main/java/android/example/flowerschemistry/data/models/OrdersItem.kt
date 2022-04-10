package android.example.flowerschemistry.data.models

data class OrdersItem(
    val addInformation: String,
    val address: String,
    val bouquet: List<Bouquet>,
    val bouquetCost: Int,
    val buyerName: String,
    val buyerPhoneNumber: String,
    val client: Client,
    val courier: Courier,
    val date: String,
    val deliveryCost: Int,
    val existTime: String,
    val finalCost: Int,
    val id: Int,
    val orderType: String,
    val qOfBouquet: Int,
    val recieverName: String,
    val recieverPhoneNumber: String,
    val status: String
)