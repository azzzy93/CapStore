package kg.geektech.capstore.ui.fragments.registration

import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kg.geektech.capstore.core.BaseFragment
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.databinding.FragmentRegistrationBinding

class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    override fun bind(): FragmentRegistrationBinding {
        return FragmentRegistrationBinding.inflate(layoutInflater)
    }

    override fun initListeners() {
        textIsEmptyListeners()

        binding.tvSignIn.setOnClickListener {
            navController.navigate(RegistrationFragmentDirections.actionRegistrationFragmentToSignInFragment())
        }

        binding.btnReg.setOnClickListener {
            val password1 = binding.etPassword.text.toString().trim()
            val password2 = binding.etPasswordConfirm.text.toString().trim()
            if (password1 != password2) {
                requireContext().showCustomToast(
                    "Введенные Вами пароли не совпадают",
                    requireActivity(),
                    layoutInflater
                )
            }
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
        binding.btnReg.isEnabled = b
        binding.leftLine.isVisible = !b
        binding.rightLine.isVisible = !b
        binding.tvOr.isVisible = !b
        binding.ivFacebook.isVisible = !b
        binding.ivGoogle.isVisible = !b
        binding.tvHaveAcc.isVisible = b
        binding.tvSignIn.isVisible = b
    }
}