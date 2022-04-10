package android.example.flowerschemistry.ui.utils

import android.example.flowerschemistry.data.models.BouquetCatalogItemItem

interface Delegates {
    interface OrderClicked {
        fun onItemClick(order: BouquetCatalogItemItem)
    }
}