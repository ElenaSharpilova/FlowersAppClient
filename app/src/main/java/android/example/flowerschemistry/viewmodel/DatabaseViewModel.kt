package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import android.example.flowerschemistry.data.repository.DatabaseRepository
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DatabaseViewModel(private val repository: DatabaseRepository): ViewModel(),
    DefaultLifecycleObserver {

   /* fun insert(item: BouquetCatalogItemItem) =
        viewModelScope.launch {
            repository.insert(item)
        }

    fun delete(item: BouquetCatalogItemItem) =
        viewModelScope.launch {
            repository.delete(item)
        }

    fun getAllShoppingItems() =
        viewModelScope.launch {
            repository.getAll()
        }

    fun clear() =
        viewModelScope.launch {
            repository.clear()
        }*/
}