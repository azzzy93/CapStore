package kg.geektech.capstore.ui.fragments.my_orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentMyOrdersBinding
import kg.geektech.capstore.models.MyOrders

class MyOrdersFragment : Fragment(), MyOrdersAdapter.OnItemClick {

    private lateinit var binding: FragmentMyOrdersBinding
    private lateinit var adapter: MyOrdersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyOrdersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initListeners()
    }

    private fun initListeners() {
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

    private fun navigateFragment(resId: Int) {
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(resId)
    }
}