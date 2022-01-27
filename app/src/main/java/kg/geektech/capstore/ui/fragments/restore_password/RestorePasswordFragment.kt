package kg.geektech.capstore.ui.fragments.restore_password

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentRestorePasswordBinding

class RestorePasswordFragment : Fragment() {

    private lateinit var binding: FragmentRestorePasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRestorePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        initListeners()
    }

    private fun setupUi() {
        val numberPhone = "+996 788 999 666"
        val text = getString(R.string.enter_6_num) + " " + numberPhone
        binding.tvDesc6.text = text
    }

    private fun initListeners() {
        binding.btnSend.setOnClickListener {
            if (binding.etNumPhone.text.toString().isNotBlank()) {
                binding.group1.visibility = View.GONE
                binding.group3.visibility = View.GONE
                binding.group2.visibility = View.VISIBLE
            }
        }

        binding.btnRestorePassword1.setOnClickListener {
            if (binding.etEnter6Num.text.toString().isNotBlank() &&
                binding.etEnter6Num.text.toString().length == 6
            ) {
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
                    showCustomToast(getString(R.string.you_update_password))
                }
            }
        }
    }

    private fun showCustomToast(text: String) {
        val layout = layoutInflater.inflate(
            R.layout.custom_toast,
            activity?.findViewById(R.id.custom_toast_layout_id)
        )
        layout.findViewById<TextView>(R.id.tv_custom_toast).text = text
        val toast = Toast(requireContext())
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
}