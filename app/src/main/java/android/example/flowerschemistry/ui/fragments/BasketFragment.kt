package android.example.flowerschemistry.ui.fragments


import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentBasketBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class BasketFragment : Fragment() {
    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBasketBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnGoToCatalog.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_basketFragment_to_homeFragment)
        }

        return view

    }

}