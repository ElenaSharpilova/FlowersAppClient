package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentBouquetBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide


class BouquetFragment : Fragment() {
    private var _binding: FragmentBouquetBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<BouquetFragmentArgs>()
    lateinit var bouquet: List<BouquetCatalogItemItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBouquetBinding.inflate(inflater, container, false)
        val view = binding.root
       binding.tvNameBouquet.text = args.aboutBouquet.name
        binding.tvPrice.text = args.aboutBouquet.cost.toString()
        binding.tvDescription.text = args.aboutBouquet.description
        Glide.with(requireContext())
            .load(args.aboutBouquet.image)
            .centerCrop()
            .into(binding.ivBouquet)

        binding.imBtnBack.setOnClickListener { findNavController().navigateUp() }

        binding.btnToOrder.setOnClickListener { findNavController().navigate(R.id.action_bouquetFragment_to_orderFragment) }

        return view
    }
}