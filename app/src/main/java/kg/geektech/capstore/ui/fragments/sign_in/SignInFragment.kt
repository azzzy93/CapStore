package kg.geektech.capstore.ui.fragments.sign_in

import androidx.core.widget.addTextChangedListener
import kg.geektech.capstore.R
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment<FragmentSignInBinding>() {

    override fun bind(): FragmentSignInBinding {
        return FragmentSignInBinding.inflate(layoutInflater)
    }

    override fun initListeners() {
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
}