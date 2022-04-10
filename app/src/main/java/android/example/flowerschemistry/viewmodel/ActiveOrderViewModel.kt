package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.data.models.Bouquet
import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import android.example.flowerschemistry.data.models.OrdersItem
import android.example.flowerschemistry.data.models.Token
import android.example.flowerschemistry.data.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ActiveOrderViewModel(private val repository: Repository): ViewModel(),
    DefaultLifecycleObserver {

    /*val activeOrderLiveData = MutableLiveData<ArrayList<OrdersItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getActiveOrder()
    }

    fun getActiveOrder(){
        viewModelScope.launch {
            val response = repository.getActiveOrder()
            if (response.isSuccessful){
                activeOrderLiveData.postValue(response.body())
            }
        }
    }*/
}