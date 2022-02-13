package kg.geektech.capstore.ui.fragments.my_order_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.databinding.FragmentMyOrderDetailBinding

class MyOrderDetailFragment : BaseFragment<FragmentMyOrderDetailBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyOrderDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }
}