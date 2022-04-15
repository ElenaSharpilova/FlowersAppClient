package android.example.flowerschemistry.ui.fragments


import android.example.flowerschemistry.R
import android.example.flowerschemistry.data.UserPreferences
import android.example.flowerschemistry.data.api.InterfaceAPI
import android.example.flowerschemistry.data.models.YourOrder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentActiveOrdersBinding
import android.example.flowerschemistry.ui.adapters.OrdersActiveAdapter
import android.example.flowerschemistry.viewmodel.ActiveOrderViewModel
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import org.koin.android.viewmodel.ext.android.viewModel


class ActiveOrdersFragment : Fragment() {
    private var _binding: FragmentActiveOrdersBinding? = null
    private val binding get() = _binding!!
    private val activeOrderViewModel by viewModel<ActiveOrderViewModel>()
    private val adapterOrdersActive by lazy { OrdersActiveAdapter() }
    lateinit var sharedPreferences: UserPreferences
    lateinit var txtData: TextView
    private val itemListOrdersActive by lazy {
       listOf(
            YourOrder(1, "Улыбка", "12.02.2021", 4330, "ул.Байтик Баатыра 17/1", "в пути", R.drawable.image_slider1),
            YourOrder(2, "Шарм", "01.08.2021", 2000, "мкр.Асанбай, д.32, кв.5", "в пути", R.drawable.image_slider2)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActiveOrdersBinding.inflate(inflater, container, false)
        val view = binding.root
        setUpRecyclerViewMyOrdersActive()

        //sharedPreferences = UserPreferences(requireContext())
        //txtData = view.findViewById(R.id.tv)
        //getUserList()

        return view
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences =  UserPreferences(requireContext())
        //lifecycle.addObserver(activeOrderViewModel)
        //setUpRecyclerViewMyOrdersActive()
        /*activeOrderViewModel.activeOrderLiveData.observe(viewLifecycleOwner){
            if (sharedPreferences.fetchToken() != null){
                binding.tv.text = it[1].toString()

            } else {
                Toast.makeText(context, "Ничего не вышло", Toast.LENGTH_SHORT).show()
            }

            //adapterOrdersActive.setData(it)
        }*/
    }*/


    private fun setUpRecyclerViewMyOrdersActive() {
        binding.rvMyActiveOrders.apply {
            adapter = adapterOrdersActive
            layoutManager = LinearLayoutManager(requireContext())
        }
        adapterOrdersActive.setData(itemListOrdersActive)
    }

    /*fun getUserList() {
        var retrofit = android.example.flowerschemistry.data.api.Retrofit.getIns()
        var apiInterface = retrofit.create(InterfaceAPI::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getActiveOrders()
                if (response.isSuccessful()) {
                    var json = Gson().toJson(response.body())
                    if (sharedPreferences.fetchToken() != null)
                        txtData.setText(json)

                    } else {
                        Toast.makeText(
                            requireContext(),
                            "No Data ",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                } else {
                    Toast.makeText(
                        requireContext(),
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }*/
}



