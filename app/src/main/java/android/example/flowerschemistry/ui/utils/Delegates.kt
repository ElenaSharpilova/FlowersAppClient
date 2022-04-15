package android.example.flowerschemistry.ui.utils

import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import android.example.flowerschemistry.data.models.BouquetSelectionItem

interface Delegates {
    interface OrderClicked {
        fun onItemClick(order: BouquetCatalogItemItem)
    }

    interface OrderClickedSelection{
        fun onItemClickSelection(item: BouquetSelectionItem)
    }
}