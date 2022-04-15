package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.data.models.*
import android.example.flowerschemistry.databinding.ItemYourOrderActiveBinding
import android.example.flowerschemistry.ui.utils.OrdersActiveDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class OrdersActiveAdapter: RecyclerView.Adapter<OrdersActiveAdapter.OrdersActiveViewHolder>() {

    private var listActiveOrder = listOf<YourOrder>()

    fun setData(newList: List<YourOrder>){
        this.listActiveOrder = newList
        notifyDataSetChanged()
    }


    class OrdersActiveViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemYourOrderActiveBinding.bind(item)
        fun bind(item: YourOrder) = with(binding){
            //Glide.with(itemView.context).load(item.image).into(ivIcon)
            ivIcon.setImageResource(item.img)
            tvTitle.text = item.name
            tvPrice.text = item.price.toString()
            tvDate.text = item.date
            tvStatus.text = item.status
            tvAddress.text = item.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersActiveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_your_order_active, parent, false)
        return OrdersActiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrdersActiveViewHolder, position: Int) {
       holder.bind(listActiveOrder[position])
    }

    override fun getItemCount(): Int {
       return listActiveOrder.size
    }
}