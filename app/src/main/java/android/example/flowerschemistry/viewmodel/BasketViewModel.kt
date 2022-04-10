package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.data.models.Basket
import android.example.flowerschemistry.data.repository.Repository
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasketViewModel(private val repository: Repository): ViewModel(), DefaultLifecycleObserver {

    val createBasket = MutableLiveData<ArrayList<Basket>>()


}