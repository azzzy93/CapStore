package kg.geektech.capstore.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentHomeBinding
import kg.geektech.capstore.models.Products
import kg.geektech.capstore.ui.adapters.ProductsAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var bestAdapter: ProductsAdapter
    private lateinit var promAdapter: ProductsAdapter

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

    private fun initListeners() {
        binding.tvWatchAllBest.setOnClickListener {
            navigateFragment(R.id.bestsellersFragment)
        }
        binding.tvWatchAllProm.setOnClickListener {
            navigateFragment(R.id.bestsellersFragment)
        }
        binding.containerForPopular.setOnClickListener {
            navigateFragment(R.id.bestsellersFragment)
        }
        binding.containerForPopular2.setOnClickListener {
            navigateFragment(R.id.productDetailFragment)
        }
    }

    private fun initAdapter() {
        bestAdapter = ProductsAdapter(fillListBest())
        binding.rvBestsellers.adapter = bestAdapter
        promAdapter = ProductsAdapter(fillListProm())
        binding.rvPromotions.adapter = promAdapter
    }

    private fun fillListBest(): List<Products> {
        val data = mutableListOf<Products>()
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        return data
    }

    private fun fillListProm(): List<Products> {
        val data = mutableListOf<Products>()
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом",
                "4600 сом"
            )
        )
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом",
                "4600 сом"
            )
        )
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом",
                "4600 сом"
            )
        )
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом",
                "4600 сом"
            )
        )
        data.add(
            Products(
                R.drawable.img_bestseller,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом",
                "4600 сом"
            )
        )
        return data
    }

    private fun navigateFragment(resId: Int) {
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(resId)
    }
}