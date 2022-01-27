package kg.geektech.capstore.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
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