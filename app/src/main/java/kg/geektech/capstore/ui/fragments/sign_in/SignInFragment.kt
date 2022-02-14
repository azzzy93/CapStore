package kg.geektech.capstore.ui.fragments.sign_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import kg.geektech.capstore.R
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment<FragmentSignInBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSignInBinding {
        return FragmentSignInBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentSignInBinding {
        return FragmentSignInBinding.bind(view)
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