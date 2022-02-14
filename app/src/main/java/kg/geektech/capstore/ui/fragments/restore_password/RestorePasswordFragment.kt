package kg.geektech.capstore.ui.fragments.restore_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geektech.capstore.R
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentRestorePasswordBinding

class RestorePasswordFragment : BaseFragment<FragmentRestorePasswordBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentRestorePasswordBinding {
        return FragmentRestorePasswordBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentRestorePasswordBinding {
        return FragmentRestorePasswordBinding.bind(view)
    }

    override fun initViews() {
        val text = getString(R.string.enter_6_num) + " +996 788 999 666"
        binding.tvDesc6.text = text
    }

    override fun initListeners() {
        binding.btnSend.setOnClickListener {
            if (binding.etNumPhone.text.toString().isNotBlank()) {
                binding.group1.visibility = View.GONE
                binding.group3.visibility = View.GONE
                binding.group2.visibility = View.VISIBLE
            }
        }

        binding.btnRestorePassword1.setOnClickListener {
            val numbers = binding.etEnter6Num.code
            if (numbers.isNotBlank() && numbers.length == 6) {
                binding.group1.visibility = View.GONE
                binding.group2.visibility = View.GONE
                binding.group3.visibility = View.VISIBLE

            }
        }

        binding.btnRestorePassword2.setOnClickListener {
            val newPassword = binding.etEnterNewPassword.text.toString()
            val newPassword2 = binding.etConfirmNewPassword.text.toString()
            if (newPassword.isNotBlank() && newPassword2.isNotBlank()) {
                if (newPassword == newPassword2) {
                    requireContext().showCustomToast(
                        getString(R.string.you_update_password),
                        requireActivity(), layoutInflater
                    )
                }
            }
        }
    }
}