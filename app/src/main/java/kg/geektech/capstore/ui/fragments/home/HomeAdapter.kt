package kg.geektech.capstore.ui.fragments.home

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.capstore.databinding.ListOfBestsellersBinding
import kg.geektech.capstore.models.Products

class HomeAdapter(private val products: List<Products>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListOfBestsellersBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        products[position].img?.let { holder.img.setImageResource(it) }
        holder.brand.text = products[position].brand
        holder.model.text = products[position].model
        holder.price.text = products[position].price
        if (products[position].priceOld != null) {
            holder.priceOld.text = products[position].priceOld
            holder.priceOld.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(binding: ListOfBestsellersBinding) : RecyclerView.ViewHolder(binding.root) {
        val img: ImageView = binding.ivBestseller
        val brand: TextView = binding.tvBrand
        val model: TextView = binding.tvModel
        val price: TextView = binding.tvPrice
        val priceOld: TextView = binding.tvPriceOld
    }
}