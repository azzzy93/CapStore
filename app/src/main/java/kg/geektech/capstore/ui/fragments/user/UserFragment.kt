package kg.geektech.capstore.ui.fragments.user

import kg.geektech.capstore.R
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentUserBinding

class UserFragment : BaseFragment<FragmentUserBinding>() {

    override fun bind(): FragmentUserBinding {
        return FragmentUserBinding.inflate(layoutInflater)
    }

    override fun initListeners() {
        binding.tvProfile.setOnClickListener {
            navigateFragment(R.id.profileFragment)
        }

        binding.tvMyOrders.setOnClickListener {
            navigateFragment(R.id.myOrdersFragment)
        }
    }
}