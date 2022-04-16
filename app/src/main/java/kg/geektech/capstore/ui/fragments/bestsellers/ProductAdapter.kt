package kg.geektech.capstore.ui.fragments.bestsellers

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geektech.capstore.databinding.ListOfBestsellersBinding
import kg.geektech.capstore.domain.product.entity.ProductEntity

class ProductAdapter :
    ListAdapter<ProductEntity, ProductAdapter.ViewHolder>(ProductDiffCallback()) {

    var onItemClick: ((product: ProductEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListOfBestsellersBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
        holder.onClick(getItem(position))
    }

    inner class ViewHolder(private val binding: ListOfBestsellersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(product: ProductEntity) {
            product.capsImage?.get(0)?.image?.let {
                Glide.with(binding.root).load(it).into(binding.ivBestseller)
            }
            binding.tvBrand.text = product.brand
            binding.tvModel.text = product.name
            val price = product.price.toString() + " сом"

            if (product.newPrice != null) {
                val oldPrice = product.price.toString() + " сом"
                binding.tvPriceOld.text = oldPrice
                val newPrice = product.newPrice.toString() + " сом"
                binding.tvPrice.text = newPrice
                binding.tvPriceOld.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                binding.tvPriceOld.visibility = View.VISIBLE
            } else {
                binding.tvPrice.text = price
                binding.tvPriceOld.visibility = View.GONE
            }
        }

        fun onClick(product: ProductEntity) {
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
                onItemClick?.invoke(product)
            }

            binding.tvBrand.setOnClickListener {
                onItemClick?.invoke(product)
            }

            binding.tvModel.setOnClickListener {
                onItemClick?.invoke(product)
            }
        }

    }

}