package kg.geektech.capstore.ui.fragments.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geektech.capstore.R
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentUserBinding

class UserFragment : BaseFragment<FragmentUserBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
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