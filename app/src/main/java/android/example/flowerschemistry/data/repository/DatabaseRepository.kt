package android.example.flowerschemistry.data.repository

import android.example.flowerschemistry.data.database.DatabaseDAO
import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import androidx.lifecycle.LiveData

class DatabaseRepository(private val dao: DatabaseDAO) {

   /* suspend fun getAll(): LiveData<List<BouquetCatalogItemItem>> {
        return dao.getAll()
    }

   suspend fun insert(item: BouquetCatalogItemItem) {
        dao.insert(item)
    }

    fun delete(item: BouquetCatalogItemItem) {
        dao.delete(item)
    }

    suspend fun clear() {
        dao.clear()
    }*/
}