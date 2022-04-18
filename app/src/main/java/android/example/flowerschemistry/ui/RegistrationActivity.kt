package android.example.flowerschemistry.ui


import android.content.Intent
import android.example.flowerschemistry.data.UserPreferences
import android.example.flowerschemistry.databinding.ActivityRegistrationBinding
import android.example.flowerschemistry.viewmodel.AuthViewModel
import android.example.flowerschemistry.viewmodel.RegistrationViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.koin.android.viewmodel.ext.android.viewModel

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding

    private val userViewModel by viewModel<RegistrationViewModel>()
    private val authViewModel by viewModel<AuthViewModel>()
    lateinit var sharedPreferences: UserPreferences
    lateinit var name: String
    lateinit var number: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = UserPreferences(applicationContext)

        binding.btnNext.setOnClickListener {
            name = binding.edTextName.text.toString()
            number = binding.edTextPhone.text.toString()
            login()
        }

    }

    private fun login() {
        //получить номер телефона из editText
        number = binding.edTextPhone.text.trim().toString()
        if (number.isNotEmpty()) {
            createUser(number, name)
            sharedPreferences.saveUserName(name)
            sharedPreferences.saveUserNumber(number)
            val intent = Intent(this, RegistrationSmsCodeActivity::class.java)
            intent.putExtra("phoneNumber", number)
            startActivity(intent)

        } else {
            Toast.makeText(this, "Введите номер телефона", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createUser(number: String, name: String) {
        userViewModel.createUser(number, name)
    }
}