package kg.geektech.capstore.ui.fragments.product_detail

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentProductDetailBinding
import kg.geektech.capstore.models.Products
import kg.geektech.capstore.ui.adapters.ImageListAdapter
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
            showCustomToast(getString(R.string.product_added_cart))
        }
    }

    private fun showCustomToast(text: String) {
        val layout = layoutInflater.inflate(
            R.layout.custom_toast,
            activity?.findViewById(R.id.custom_toast_layout_id)
        )
        layout.findViewById<TextView>(R.id.tv_custom_toast).text = text
        val toast = Toast(requireContext())
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
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
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
            )
        )
        data.add(
            Products(
                R.drawable.cap_3,
                "Adidas",
                "San Francisco Baseball",
                "3800 сом"
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