package kg.geektech.capstore.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import kg.geektech.capstore.R
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentProfileBinding {
        return FragmentProfileBinding.bind(view)
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        binding.btnEditProfile.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(BUNDLE_NAME, binding.tvName.text.toString())
            bundle.putString(BUNDLE_EMAIL, binding.tvEmail.text.toString())
            bundle.putString(BUNDLE_PHONE, binding.tvPhoneNumber.text.toString())
            bundle.putString(BUNDLE_ADDRESS, binding.tvAddress.text.toString())
            val navHostFragment =
                activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.editProfileFragment, bundle)
        }
    }

    companion object {
        const val BUNDLE_NAME = "BUNDLE_NAME"
        const val BUNDLE_EMAIL = "BUNDLE_EMAIL"
        const val BUNDLE_PHONE = "BUNDLE_PHONE"
        const val BUNDLE_ADDRESS = "BUNDLE_ADDRESS"
    }
}