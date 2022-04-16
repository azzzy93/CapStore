package kg.geektech.capstore.ui.fragments.user

import kg.geektech.capstore.core.base.BaseFragment
import kg.geektech.capstore.databinding.FragmentUserBinding

class UserFragment : BaseFragment<FragmentUserBinding>() {

    override fun bind(): FragmentUserBinding {
        return FragmentUserBinding.inflate(layoutInflater)
    }

    override fun initListeners() {
        binding.tvProfile.setOnClickListener {
            navController.navigate(UserFragmentDirections.actionUserFragmentToProfileFragment())
        }

        binding.tvMyOrders.setOnClickListener {
            navController.navigate(UserFragmentDirections.actionUserFragmentToMyOrdersFragment())
        }
    }
}