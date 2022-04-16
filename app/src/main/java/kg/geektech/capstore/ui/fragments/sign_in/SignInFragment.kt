package kg.geektech.capstore.ui.fragments.sign_in

import androidx.core.widget.addTextChangedListener
import kg.geektech.capstore.core.base.BaseFragment
import kg.geektech.capstore.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment<FragmentSignInBinding>() {

    override fun bind(): FragmentSignInBinding {
        return FragmentSignInBinding.inflate(layoutInflater)
    }

    override fun initListeners() {
        textIsEmptyListeners()

        binding.tvRestore.setOnClickListener {
            navController.navigate(SignInFragmentDirections.actionSignInFragmentToRestorePasswordFragment())
        }

        binding.tvRegistration.setOnClickListener {
            navController.navigate(SignInFragmentDirections.actionSignInFragmentToRegistrationFragment())
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