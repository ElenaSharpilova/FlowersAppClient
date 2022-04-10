package android.example.flowerschemistry.data.database

import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface DatabaseDAO {
    @Query("SELECT * from cart_bouquets")
    fun getItems(): Flow<List<BouquetCatalogItemItem>>
}