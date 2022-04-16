package kg.geektech.capstore.ui.fragments.my_order_detail

import kg.geektech.capstore.core.BaseFragment
import kg.geektech.capstore.databinding.FragmentMyOrderDetailBinding

class MyOrderDetailFragment : BaseFragment<FragmentMyOrderDetailBinding>() {

    override fun bind(): FragmentMyOrderDetailBinding {
        return FragmentMyOrderDetailBinding.inflate(layoutInflater)
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            navController.navigateUp()
        }
    }
}