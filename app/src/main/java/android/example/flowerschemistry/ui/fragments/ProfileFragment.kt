package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.Constants
import android.example.flowerschemistry.data.UserPreferences
import android.example.flowerschemistry.databinding.FragmentProfileBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.viewmodel.AuthViewModel
import android.example.flowerschemistry.viewmodel.RegistrationViewModel
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val userViewModel by viewModel<RegistrationViewModel>()
    private val authViewModel by viewModel<AuthViewModel>()
    lateinit var sharedPreferences: UserPreferences
    lateinit var name: String
    lateinit var number: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedPreferences =  UserPreferences(requireContext())
        binding.name.text = sharedPreferences.fetchUserName()
        binding.number.text = sharedPreferences.fetchUserNumber()

        binding.imBtnBack.setOnClickListener { findNavController().navigateUp() }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.text = sharedPreferences.fetchUserName()
        binding.number.text = sharedPreferences.fetchUserNumber()
    }

}