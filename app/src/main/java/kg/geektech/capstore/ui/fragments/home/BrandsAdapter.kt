package kg.geektech.capstore.ui.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.capstore.databinding.ListBrandsForHomeBinding
import kg.geektech.capstore.models.Products

class BrandsAdapter(private val list: List<Products>) :
    RecyclerView.Adapter<BrandsAdapter.BrandsViewHolder>() {

    private lateinit var onItemClick: OnItemClick

    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BrandsAdapter.BrandsViewHolder {
        val binding =
            ListBrandsForHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BrandsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandsAdapter.BrandsViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.initListeners(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class BrandsViewHolder(private val binding: ListBrandsForHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(product: Products) {
            product.brandImg?.let { binding.ivBrand.setImageResource(it) }
            binding.tvBrand.text = product.brand
        }

        fun initListeners(product: Products) {
            itemView.setOnClickListener {
                onItemClick.onItemClick(product)
            }
        }
    }

    interface OnItemClick {
        fun onItemClick(product: Products)
    }
}