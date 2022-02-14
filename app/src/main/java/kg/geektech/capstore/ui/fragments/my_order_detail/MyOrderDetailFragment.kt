package kg.geektech.capstore.ui.fragments.my_order_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentBestsellersBinding
import kg.geektech.capstore.databinding.FragmentMyOrderDetailBinding

class MyOrderDetailFragment : BaseFragment<FragmentMyOrderDetailBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMyOrderDetailBinding {
        return FragmentMyOrderDetailBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentMyOrderDetailBinding {
        return FragmentMyOrderDetailBinding.bind(view)
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }
}