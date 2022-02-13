package kg.geektech.capstore.ui.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kg.geektech.capstore.R
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentRegistrationBinding

class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initListeners() {
        textIsEmptyListeners()

        binding.tvSignIn.setOnClickListener {
            navigateFragment(R.id.signInFragment)
        }
    }

    private fun textIsEmptyListeners() {
        binding.etName.addTextChangedListener { _name ->
            val name = _name.toString().trim()
            val number = binding.etNumPhone.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val passwordConfirm = binding.etPasswordConfirm.text.toString().trim()

            if (name.isNotEmpty() && number.isNotEmpty() &&
                password.isNotEmpty() && passwordConfirm.isNotEmpty()
            ) {
                ifFilled(true)
            } else {
                ifFilled(false)
            }
        }

        binding.etNumPhone.addTextChangedListener { _number ->
            val name = binding.etName.text.toString().trim()
            val number = _number.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val passwordConfirm = binding.etPasswordConfirm.text.toString().trim()
            if (name.isNotEmpty() && number.isNotEmpty() &&
                password.isNotEmpty() && passwordConfirm.isNotEmpty()
            ) {
                ifFilled(true)
            } else {
                ifFilled(false)
            }
        }

        binding.etPassword.addTextChangedListener { _password ->
            val name = binding.etName.text.toString().trim()
            val number = binding.etNumPhone.text.toString().trim()
            val password = _password.toString().trim()
            val passwordConfirm = binding.etPasswordConfirm.text.toString().trim()
            if (name.isNotEmpty() && number.isNotEmpty() &&
                password.isNotEmpty() && passwordConfirm.isNotEmpty()
            ) {
                ifFilled(true)
            } else {
                ifFilled(false)
            }
        }

        binding.etPasswordConfirm.addTextChangedListener { _passwordConfirm ->
            val name = binding.etName.text.toString().trim()
            val number = binding.etNumPhone.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val passwordConfirm = _passwordConfirm.toString().trim()
            if (name.isNotEmpty() && number.isNotEmpty() &&
                password.isNotEmpty() && passwordConfirm.isNotEmpty()
            ) {
                ifFilled(true)
            } else {
                ifFilled(false)
            }
        }
    }

    private fun ifFilled(b: Boolean) {
        if (b) {
            binding.btnReg.isEnabled = true
            binding.leftLine.isVisible = false
            binding.rightLine.isVisible = false
            binding.tvOr.isVisible = false
            binding.ivFacebook.isVisible = false
            binding.ivGoogle.isVisible = false
            binding.tvHaveAcc.isVisible = true
            binding.tvSignIn.isVisible = true
        } else {
            binding.btnReg.isEnabled = false
            binding.leftLine.isVisible = true
            binding.rightLine.isVisible = true
            binding.tvOr.isVisible = true
            binding.ivFacebook.isVisible = true
            binding.ivGoogle.isVisible = true
            binding.tvHaveAcc.isVisible = false
            binding.tvSignIn.isVisible = false
        }
    }
}