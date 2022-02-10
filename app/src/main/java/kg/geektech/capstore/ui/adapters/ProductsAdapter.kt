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

    private lateinit var onItemClick: OnItemClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListOfBestsellersBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(products[position])
        holder.onItemClickListeners(products[position])
    }

    override fun getItemCount(): Int = products.size

    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }

    inner class ViewHolder(private val binding: ListOfBestsellersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(product: Products) {
            product.img?.let { binding.ivBestseller.setImageResource(it) }
            binding.tvBrand.text = product.brand
            binding.tvModel.text = product.model
            val price = product.price.toString() + " сом"
            binding.tvPrice.text = price
        }

        fun onItemClickListeners(product: Products) {
            if (product.priceOld != null) {
                val oldPrice = product.priceOld.toString() + " сом"
                binding.tvPriceOld.text = oldPrice
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

            binding.containerForImage.setOnClickListener {
                onItemClick.onClick(product)
            }

            binding.tvBrand.setOnClickListener {
                onItemClick.onClick(product)
            }

            binding.tvModel.setOnClickListener {
                onItemClick.onClick(product)
            }

            binding.tvPrice.setOnClickListener {
                onItemClick.onClick(product)
            }

            binding.tvPriceOld.setOnClickListener {
                onItemClick.onClick(product)
            }

        }
    }

    interface OnItemClick {
        fun onClick(product: Products)
    }
}