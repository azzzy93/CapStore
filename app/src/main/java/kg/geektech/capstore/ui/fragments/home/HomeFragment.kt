package kg.geektech.capstore.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.geektech.capstore.R
import kg.geektech.capstore.databinding.FragmentHomeBinding
import kg.geektech.capstore.models.Products

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUi()
    }

    private fun updateUi() {
        binding.rvBestsellers.adapter = HomeAdapter(fillListBest())
        binding.rvPromotions.adapter = HomeAdapter(fillListProm())
    }

    private fun fillListBest(): List<Products> {
        val data = mutableListOf<Products>()
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом"))
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом"))
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом"))
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом"))
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом"))
        return data
    }

    private fun fillListProm(): List<Products> {
        val data = mutableListOf<Products>()
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом", "4600 сом"))
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом", "4600 сом"))
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом", "4600 сом"))
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом", "4600 сом"))
        data.add(Products(R.drawable.img_bestseller, "Adidas", "San Francisco Baseball", "3800 сом", "4600 сом"))
        return data
    }
}