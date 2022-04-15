package android.example.flowerschemistry.ui

import android.content.Intent
import android.example.flowerschemistry.data.UserPreferences
import android.example.flowerschemistry.databinding.ActivityRegistrationSmsCodeBinding
import android.example.flowerschemistry.viewmodel.AuthViewModel
import android.example.flowerschemistry.viewmodel.RegistrationViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit

class RegistrationSmsCodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationSmsCodeBinding
    lateinit var auth: FirebaseAuth
    private var id: String = ""
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private val number by lazy { intent.getStringExtra("phoneNumber") }
    lateinit var name: String
    private val authViewModel by viewModel<AuthViewModel>()
    private val userViewModel by viewModel<RegistrationViewModel>()
    lateinit var sharedPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationSmsCodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = UserPreferences(this)
        Log.i("auth", "on create")


        auth = FirebaseAuth.getInstance()

        binding.tvPhoneNumber.text = number.toString()
        startTimer()

        // Кнопка отправляет обратоно смс код и заноно запускает таймер
        binding.tvSkip.setOnClickListener {
            sendVerificationCode()
            startTimer()
        }

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            // Этот метод вызывается после завершения проверки
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.i("auth", "on verification complete")
            }

            // Вызывается, когда проверка не удалась
            override fun onVerificationFailed(e: FirebaseException) {
                Log.d("GFG" , "Верификация не удалась $e")
            }

            // При отправке кода Firebase вызывается этот метод
            //здесь мы начинаем новую активность, в которой пользователь может ввести OTP
            override fun onCodeSent(
                p0: String, p1: PhoneAuthProvider.ForceResendingToken
            ) {
                id = p0
                Toast.makeText(this@RegistrationSmsCodeActivity,
                    "Сообщение отправленно", Toast.LENGTH_LONG).show()
            }
        }

        sendVerificationCode()

        // заполняем otp и вызывем по нажатии на кнопку
        binding.btnNext.setOnClickListener {
            val otp = binding.pinView.text?.trim().toString()
            if(otp.isNotEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    id, otp)
                signInWithPhoneAuthCredential(credential)
            }else{
                Toast.makeText(this,"Enter OTP", Toast.LENGTH_SHORT).show()
            }
        }





        binding.linearLayoutBack.setOnClickListener {
            onBackPressed()
        }
    }

    // этот метод отправляет код подтверждения и запускает обратный вызов проверки
    // который реализован выше в onCreate
    private fun sendVerificationCode() {
        PhoneAuthOptions.newBuilder()
            .setActivity(this)
            .setPhoneNumber(number!!)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setCallbacks(callbacks)
            .build()
            .apply {
                PhoneAuthProvider.verifyPhoneNumber(this)
            }
    }

    // проверяем, соответствует ли код, отправленный firebase
    // в случае успеха запускаем новое activity
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this , MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show()
                } else {
                    // если ошибка входа, отобразится сообщение
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // Введенный код подтверждения недействителен
                        Toast.makeText(this, "Неверный код", Toast.LENGTH_SHORT).show()
                        binding.tvIncorrectCode.visibility = View.VISIBLE
                    }
                }
            }
    }

    // Зпуск таймера чтобы пользователь за 60 сек ввел смс код
    private fun startTimer() {
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = "Осталось: 00:${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                binding.tvTimer.text = "Время вышло"
            }
        }.start()
    }

    /*private fun getToken(number: String) {
        authViewModel.getToken(number)
        authViewModel.token.observe(this) {
            val token: String = it.token
            val jwt = JWT(token)
            val name: Claim = jwt.getClaim("name")
            sharedPreferences.saveToken(token)
            sharedPreferences.saveUserName(name.asString())
            sharedPreferences.saveUserNumber(number)
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
        authViewModel.errorMessage.observe(this) {
            Log.i("auth", "error observe")
            Toast.makeText(this, "Такого номера нет!", Toast.LENGTH_SHORT).show()
        }
    }*/


}