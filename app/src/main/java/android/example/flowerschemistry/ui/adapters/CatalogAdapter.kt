package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardCatalogBinding
import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import android.example.flowerschemistry.ui.utils.Delegates
import android.example.flowerschemistry.ui.utils.OnItemClickListenerCatalog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class CatalogAdapter(private val orderClicked: Delegates.OrderClicked): RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {

    private var listCatalog = listOf<BouquetCatalogItemItem>()

    fun setData(newList: List<BouquetCatalogItemItem>){
       this.listCatalog = newList
        notifyDataSetChanged()
    }


    inner class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemCardCatalogBinding.bind(item)
        fun bind(card:BouquetCatalogItemItem) = with(binding){
            Glide.with(itemView.context).load(card.image).into(ivBouquetCatalog)
            tvBouquetName.text = card.name
            tvBouquetDescription.text = card.description
            tvPrice.text = card.cost.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_catalog, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogAdapter.ViewHolder, position: Int) {
        holder.bind(listCatalog[position])
        holder.binding.cvBouquet.setOnClickListener {
            orderClicked.onItemClick(listCatalog[position])
        }
    }

    override fun getItemCount(): Int {
        return listCatalog.size
    }
}