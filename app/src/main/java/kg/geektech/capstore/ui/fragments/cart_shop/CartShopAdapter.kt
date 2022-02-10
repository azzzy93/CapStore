package kg.geektech.capstore.ui.fragments.cart_shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.capstore.databinding.ListOfCartShopBinding
import kg.geektech.capstore.models.Products

class CartShopAdapter(private val list: ArrayList<Products>) :
    RecyclerView.Adapter<CartShopAdapter.MineViewHolder>() {

    private lateinit var onItemClick: OnItemClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MineViewHolder {
        val binding =
            ListOfCartShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MineViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.initListeners(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }

    inner class MineViewHolder(val binding: ListOfCartShopBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(product: Products) {
            product.img?.let { binding.ivCap.setImageResource(it) }
            binding.tvBrand.text = product.brand
            binding.tvModel.text = product.model
            val price = product.price.toString() + "сом"
            binding.tvPrice.text = price
            binding.tvCartCount.text = product.count.toString()
            binding.tvSize.text = product.size
        }

        fun initListeners(product: Products) {
            binding.ivTrash.setOnClickListener {
                onItemClick.onItemClick(btn = "trash")
            }
            binding.ivPlus.setOnClickListener {
                if (product.count != null) {
                    product.count = product.count!! + 1
                    val sum: String = (product.price!! * product.count!!).toString() + " сом"
                    onItemClick.onItemClick(sum, "sum")
                }
                notifyItemChanged(adapterPosition)
            }
            binding.ivMinus.setOnClickListener {
                if (product.count != null) {
                    if (product.count!! <= 0) {
                        product.count = 0
                    } else {
                        product.count = product.count!! - 1
                    }
                    val sum: String = (product.price!! * product.count!!).toString() + " сом"
                    onItemClick.onItemClick(sum, "sum")
                }
                notifyItemChanged(adapterPosition)
            }
        }
    }

    interface OnItemClick {
        fun onItemClick(sum: String? = null, btn: String? = null)
    }
}