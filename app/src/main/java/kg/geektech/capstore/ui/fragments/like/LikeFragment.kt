package kg.geektech.capstore.ui.fragments.like

import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.capstore.R
import kg.geektech.capstore.core.base.BaseFragment
import kg.geektech.capstore.data.models.Products
import kg.geektech.capstore.databinding.FragmentBestsellersBinding
import kg.geektech.capstore.ui.adapters.ProductsAdapter

class LikeFragment : BaseFragment<FragmentBestsellersBinding>(), ProductsAdapter.OnItemClick {

    private lateinit var adapter: ProductsAdapter

    override fun bind(): FragmentBestsellersBinding {
        return FragmentBestsellersBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding.tvTitle.text = getString(R.string.favorites)
        initAdapter()
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            navController.navigateUp()
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
        for (i in 0..10) {
            data.add(Products(
                img = R.drawable.img_cap,
                brand = "Adidas",
                model = "San Francisco Baseball",
                price = 2500
            ))
        }
        return data
    }

    override fun onClick(product: Products) {
        navController.navigate(LikeFragmentDirections.actionLikeFragmentToProductDetailFragment())
    }
}