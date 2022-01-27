package kg.geektech.capstore.ui.fragments.like

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentBestsellersBinding
import kg.geektech.capstore.models.Products
import kg.geektech.capstore.ui.adapters.ProductsAdapter

class LikeFragment : Fragment(), ProductsAdapter.OnItemClick {

    private lateinit var binding: FragmentBestsellersBinding
    private lateinit var adapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBestsellersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initAdapter()
        initListeners()
    }

    private fun initView() {
        binding.tvTitle.text = getString(R.string.favorites)
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    private fun initAdapter() {
        adapter = ProductsAdapter(fillList())
        adapter.setOnItemClick(this)
        binding.rv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rv.adapter = adapter
    }

    private fun fillList(): List<Products> {
        val data = mutableListOf<Products>()
        data.add(
            Products(
                R.drawable.cap_2,
                "New Era",
                "French Fries Series",
                "4500 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_2,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_4,
                "Nike",
                "New York yankies",
                "3500 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_3,
                "New Era",
                "French Fries Series",
                "4500 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_1,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_2,
                "Nike",
                "New York yankies",
                "3500 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_4,
                "New Era",
                "French Fries Series",
                "4500 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_4,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_4,
                "Nike",
                "New York yankies",
                "3500 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_2,
                "New Era",
                "French Fries Series",
                "4500 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_1,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_1,
                "Nike",
                "New York yankies",
                "3500 сом"
            )
        )
        return data
    }

    override fun onClick(product: Products) {
        navigateFragment(R.id.productDetailFragment)
    }

    private fun navigateFragment(resId: Int) {
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(resId)
    }

}