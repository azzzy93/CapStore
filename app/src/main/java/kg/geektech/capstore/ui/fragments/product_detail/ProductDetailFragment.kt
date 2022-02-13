package kg.geektech.capstore.ui.fragments.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentProductDetailBinding
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.data.models.Products
import kg.geektech.capstore.ui.adapters.ProductsAdapter

class ProductDetailFragment : Fragment(), ProductsAdapter.OnItemClick {

    private lateinit var binding: FragmentProductDetailBinding
    private lateinit var listAdapter: ImageListAdapter
    private lateinit var similarAdapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initListeners()
    }

    private fun initListeners() {
        binding.containerForLike.setOnClickListener {
            if (binding.ivLikeSelected.visibility == View.GONE) {
                binding.ivLikeSelected.visibility = View.VISIBLE
                binding.ivLike.visibility = View.GONE
            } else {
                binding.ivLike.visibility = View.VISIBLE
                binding.ivLikeSelected.visibility = View.GONE
            }
        }

        binding.btnAddCart.setOnClickListener {
            requireContext().showCustomToast(
                getString(R.string.product_added_cart),
                requireActivity(),
                layoutInflater
            )
        }
    }

    private fun initAdapter() {
        listAdapter = ImageListAdapter(fillListImg())
        binding.viewPagerForImage.adapter = listAdapter
        TabLayoutMediator(
            binding.tabLayoutForImages,
            binding.viewPagerForImage
        ) { _, _ -> }.attach()

        similarAdapter = ProductsAdapter(fillList())
        similarAdapter.setOnItemClick(this)
        binding.rvSimilarProd.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvSimilarProd.adapter = similarAdapter
    }

    private fun fillList(): List<Products> {
        val data = mutableListOf<Products>()
        for (i in 0..10) {
            data.add(
                Products(
                    img = R.drawable.img_cap,
                    brand = "Adidas",
                    model = "San Francisco Baseball",
                    price = 2500
                )
            )
        }
        return data
    }

    private fun fillListImg(): List<Int> {
        return mutableListOf(
            R.drawable.banner_2_cap,
            R.drawable.banner_1_right_cap,
            R.drawable.banner_2_cap,
            R.drawable.banner_1_right_cap
        )
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