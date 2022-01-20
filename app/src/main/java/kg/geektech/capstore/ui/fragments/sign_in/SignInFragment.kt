package kg.geektech.capstore.ui.fragments.sign_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        textIsEmptyListeners()

        binding.tvRestore.setOnClickListener {
            navigateFragment(R.id.restorePasswordFragment)
        }

        binding.tvRegistration.setOnClickListener {
            navigateFragment(R.id.registrationFragment)
        }
    }

    private fun textIsEmptyListeners() {
        binding.etNumPhone.addTextChangedListener { num ->
            val password = binding.etPassword.text.toString().trim()
            val number = num.toString().trim()
            binding.btnSignIn.isEnabled = password.isNotEmpty() && number.isNotEmpty()
        }

        binding.etPassword.addTextChangedListener { pass ->
            val password = pass.toString().trim()
            val number = binding.etNumPhone.text.toString().trim()
            binding.btnSignIn.isEnabled = password.isNotEmpty() && number.isNotEmpty()
        }
    }

    private fun navigateFragment(resId: Int) {
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(resId)
    }
}