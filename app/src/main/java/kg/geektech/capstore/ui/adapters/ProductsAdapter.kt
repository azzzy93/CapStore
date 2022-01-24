package kg.geektech.capstore.ui.adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.capstore.databinding.ListOfBestsellersBinding
import kg.geektech.capstore.models.Products

class ProductsAdapter(private val products: List<Products>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListOfBestsellersBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(private val binding: ListOfBestsellersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(product: Products) {
            product.img?.let { binding.ivBestseller.setImageResource(it) }
            binding.tvBrand.text = product.brand
            binding.tvModel.text = product.model
            binding.tvPrice.text = product.price
            if (product.priceOld != null) {
                binding.tvPriceOld.text = product.priceOld
                binding.tvPriceOld.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                binding.tvPriceOld.visibility = View.VISIBLE
            } else {
                binding.tvPriceOld.visibility = View.GONE
            }
            binding.containerLike.setOnClickListener {
                if (binding.ivLikeSelected.visibility == View.GONE) {
                    binding.ivLike.visibility = View.GONE
                    binding.ivLikeSelected.visibility = View.VISIBLE
                } else {
                    binding.ivLikeSelected.visibility = View.GONE
                    binding.ivLike.visibility = View.VISIBLE
                }
            }
        }

    }
}