package kg.geektech.capstore.ui.fragments.product_detail

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import kg.geektech.capstore.R
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.core.base.BaseFragment
import kg.geektech.capstore.data.models.Products
import kg.geektech.capstore.databinding.FragmentProductDetailBinding
import kg.geektech.capstore.ui.adapters.ProductsAdapter

class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding>(),
    ProductsAdapter.OnItemClick {

    private lateinit var listAdapter: ImageListAdapter
    private lateinit var similarAdapter: ProductsAdapter

    override fun bind(): FragmentProductDetailBinding {
        return FragmentProductDetailBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        initAdapter()
    }

    override fun initListeners() {
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
        navController.navigate(ProductDetailFragmentDirections.actionProductDetailFragmentSelf())
    }
}