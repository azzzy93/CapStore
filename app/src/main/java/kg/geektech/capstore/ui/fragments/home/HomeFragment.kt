package kg.geektech.capstore.ui.fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.capstore.R
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.core.ui.BaseFragment
import kg.geektech.capstore.data.models.Products
import kg.geektech.capstore.databinding.FragmentHomeBinding
import kg.geektech.capstore.ui.adapters.ProductsAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var bestAdapter: ProductsAdapter
    private lateinit var promAdapter: ProductsAdapter
    private lateinit var brandsAdapter: BrandsAdapter

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentHomeBinding {
        return FragmentHomeBinding.bind(view)
    }

    override fun initViews() {
        initAdapter()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun initListeners() {
        binding.tvWatchAllBest.setOnClickListener {
            navigateFragment(R.id.bestsellersFragment)
        }
        binding.tvWatchAllProm.setOnClickListener {
            navigateFragment(R.id.bestsellersFragment)
        }
        bestAdapter.setOnItemClick(object : ProductsAdapter.OnItemClick {
            override fun onClick(product: Products) {
                navigateFragment(R.id.productDetailFragment)
            }
        })
        promAdapter.setOnItemClick(object : ProductsAdapter.OnItemClick {
            override fun onClick(product: Products) {
                navigateFragment(R.id.productDetailFragment)
            }
        })
        brandsAdapter.setOnItemClick(object : BrandsAdapter.OnItemClick {
            override fun onItemClick(product: Products) {
                navigateFragment(R.id.bestsellersFragment)
            }
        })
        binding.etSearch.setOnTouchListener { _, event ->
            val DRAWABLE_LEFT = 0
            val DRAWABLE_RIGHT = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (binding.etSearch.right - binding.etSearch.compoundDrawables[DRAWABLE_RIGHT].bounds.width())) {
                    navigateFragment(R.id.sortFragment)
                    true
                } else if (event.rawX <= (binding.etSearch.left + binding.etSearch.compoundDrawables[DRAWABLE_LEFT].bounds.width())) {
                    requireContext().showCustomToast("LEFT", requireActivity(), layoutInflater)
                    true
                }
            }
            false
        }
    }

    private fun initAdapter() {
        bestAdapter = ProductsAdapter(fillListBest())
        binding.rvBestsellers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBestsellers.adapter = bestAdapter

        promAdapter = ProductsAdapter(fillListProm())
        binding.rvPromotions.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvPromotions.adapter = promAdapter

        brandsAdapter = BrandsAdapter(fillListBrands())
        binding.rvBrands.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBrands.adapter = brandsAdapter
    }

    private fun fillListBrands(): List<Products> {
        val data = mutableListOf<Products>()
        for (i in 0..10) {
            data.add(
                Products(
                    brand = "Adidas",
                    brandImg = R.drawable.img_adidas_round_for_home,
                )
            )
        }
        return data
    }

    private fun fillListBest(): List<Products> {
        val data = mutableListOf<Products>()
        for (i in 0..10) {
            data.add(
                Products(
                    img = R.drawable.img_cap,
                    brand = "Adidas",
                    model = "San Francisco Baseball",
                    price = 2500,
                )
            )
        }
        return data
    }

    private fun fillListProm(): List<Products> {
        val data = mutableListOf<Products>()
        for (i in 0..10) {
            data.add(
                Products(
                    img = R.drawable.img_cap,
                    brand = "Adidas",
                    model = "San Francisco Baseball",
                    price = 2500,
                    priceOld = 3500,
                )
            )
        }
        return data
    }
}