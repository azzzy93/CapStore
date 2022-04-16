package kg.geektech.capstore.ui.fragments.profile

import kg.geektech.capstore.core.base.BaseFragment
import kg.geektech.capstore.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun bind(): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(layoutInflater)
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            navController.navigateUp()
        }

        binding.btnEditProfile.setOnClickListener {
            val userName = binding.tvName.text.toString()
            val userEmail = binding.tvEmail.text.toString()
            val userPhone = binding.tvPhoneNumber.text.toString()
            val userAddress = binding.tvAddress.text.toString()
            navController.navigate(
                ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment(
                    userName,
                    userEmail,
                    userPhone,
                    userAddress
                )
            )
        }
    }
}