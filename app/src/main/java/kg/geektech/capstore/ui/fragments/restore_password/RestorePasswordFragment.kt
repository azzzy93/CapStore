package kg.geektech.capstore.ui.fragments.restore_password

import android.view.View
import kg.geektech.capstore.R
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.core.BaseFragment
import kg.geektech.capstore.databinding.FragmentRestorePasswordBinding

class RestorePasswordFragment : BaseFragment<FragmentRestorePasswordBinding>() {

    override fun bind(): FragmentRestorePasswordBinding {
        return FragmentRestorePasswordBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        val text = getString(R.string.enter_6_num) + " " + "azizbek3993@gmail.com"
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