package android.example.flowerschemistry.data.database

import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface DatabaseDAO {
    /*@Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(bouquetItem: BouquetCatalogItemItem)

    @Delete
    fun delete(bouquetItem: BouquetCatalogItemItem)

    @Query("SELECT * FROM cart_bouquets")
    suspend fun getAll(): LiveData<List<BouquetCatalogItemItem>>

    @Query("DELETE FROM cart_bouquets")
    suspend fun clear()*/
}