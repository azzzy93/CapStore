package kg.geektech.capstore.ui.fragments.bestsellers

import androidx.recyclerview.widget.DiffUtil
import kg.geektech.capstore.domain.product.entity.ProductEntity

class ProductDiffCallback : DiffUtil.ItemCallback<ProductEntity>() {

    override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity) =
        oldItem == newItem
}