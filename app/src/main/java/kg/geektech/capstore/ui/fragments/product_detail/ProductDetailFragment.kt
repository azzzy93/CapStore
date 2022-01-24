package kg.geektech.capstore.ui.fragments.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentProductDetailBinding
import kg.geektech.capstore.models.Products
import kg.geektech.capstore.ui.adapters.ImageListAdapter
import kg.geektech.capstore.ui.adapters.ProductsAdapter

class ProductDetailFragment : Fragment() {

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
    }

    private fun initAdapter() {
        listAdapter = ImageListAdapter(fillListImg())
        binding.viewPagerForImage.adapter = listAdapter
        TabLayoutMediator(
            binding.tabLayoutForImages,
            binding.viewPagerForImage
        ) { _, _ -> }.attach()

        similarAdapter = ProductsAdapter(fillList())
        binding.rvSimilarProd.adapter = similarAdapter
    }

    private fun fillList(): List<Products> {
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

    private fun fillListImg(): List<Int> {
        return mutableListOf(
            R.drawable.img_banner_2,
            R.drawable.img_banner_1_right_2,
            R.drawable.img_banner_2,
            R.drawable.img_banner_1_right_2
        )
    }
}