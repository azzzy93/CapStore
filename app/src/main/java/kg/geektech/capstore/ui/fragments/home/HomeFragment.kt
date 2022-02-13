package kg.geektech.capstore.ui.fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.capstore.R
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.data.models.Products
import kg.geektech.capstore.databinding.FragmentHomeBinding
import kg.geektech.capstore.ui.adapters.ProductsAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var bestAdapter: ProductsAdapter
    private lateinit var promAdapter: ProductsAdapter
    private lateinit var brandsAdapter: BrandsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initListeners()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListeners() {
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

    private fun navigateFragment(resId: Int) {
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(resId)
    }
}