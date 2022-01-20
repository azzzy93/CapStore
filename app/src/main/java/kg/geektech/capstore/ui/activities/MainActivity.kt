package kg.geektech.capstore.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.ActivityMainBinding
import kg.geektech.capstore.ui.fragments.registration.RegistrationFragment
import kg.geektech.capstore.ui.fragments.restore_password.RestorePasswordFragment
import kg.geektech.capstore.ui.fragments.sign_in.SignInFragment
import kg.geektech.capstore.ui.fragments.start.StartFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}