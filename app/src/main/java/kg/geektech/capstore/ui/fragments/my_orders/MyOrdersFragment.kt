package kg.geektech.capstore.ui.fragments.my_orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.capstore.R
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.data.models.MyOrders
import kg.geektech.capstore.databinding.FragmentMyOrdersBinding

class MyOrdersFragment : BaseFragment<FragmentMyOrdersBinding>(), MyOrdersAdapter.OnItemClick {

    private lateinit var adapter: MyOrdersAdapter

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMyOrdersBinding {
        return FragmentMyOrdersBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentMyOrdersBinding {
        return FragmentMyOrdersBinding.bind(view)
    }

    override fun initViews() {
        initAdapter()
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    private fun initAdapter() {
        adapter = MyOrdersAdapter(fillList())
        adapter.setOnItemClick(this)
        binding.rvMyOrders.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMyOrders.adapter = adapter
    }

    private fun fillList(): ArrayList<MyOrders> {
        val list = arrayListOf<MyOrders>()
        list.add(MyOrders("88687892", "27.01.2022", "Доставлено"))
        list.add(MyOrders("54646528", "27.01.2022", "В пути"))
        list.add(MyOrders("48515348", "27.01.2022", "Отказано"))
        list.add(MyOrders("48348450", "27.01.2022", "Доставлено"))
        list.add(MyOrders("12345678", "27.01.2022", "Доставлено"))
        list.add(MyOrders("11111111", "27.01.2022", "Доставлено"))
        list.add(MyOrders("22335566", "27.01.2022", "Доставлено"))
        list.add(MyOrders("78948003", "27.01.2022", "Доставлено"))
        return list
    }

    override fun onClick(myOrder: MyOrders) {
        navigateFragment(R.id.myOrderDetailFragment)
    }
}