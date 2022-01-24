package kg.geektech.capstore.ui.fragments.bestsellers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentBestsellersBinding
import kg.geektech.capstore.models.Products
import kg.geektech.capstore.ui.adapters.ProductsAdapter

class BestsellersFragment : Fragment() {

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
        binding.tvTitle.text = getString(R.string.bestsellers)
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    private fun initAdapter() {
        adapter = ProductsAdapter(fillList())
        binding.rv.adapter = adapter
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
}