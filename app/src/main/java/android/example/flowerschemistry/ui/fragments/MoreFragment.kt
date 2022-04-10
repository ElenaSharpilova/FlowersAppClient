package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.example.flowerschemistry.data.UserPreferences
import androidx.fragment.app.Fragment
import android.example.flowerschemistry.databinding.FragmentMoreBinding
import android.example.flowerschemistry.viewmodel.AuthViewModel
import android.example.flowerschemistry.viewmodel.RegistrationViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import org.koin.android.viewmodel.ext.android.viewModel


class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnProfile.setOnClickListener { Navigation.findNavController(view)
            .navigate(R.id.action_moreFragment_to_profileFragment) }

        binding.btnContacts.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_moreFragment_to_contactsFragment)
        }

        binding.btnHistoryOrder.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_moreFragment_to_yourOrdersFragment)
        }


        return view

    }

}


