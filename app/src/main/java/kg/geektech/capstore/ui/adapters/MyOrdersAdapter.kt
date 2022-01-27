package kg.geektech.capstore.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.capstore.databinding.ListMyOrdersBinding
import kg.geektech.capstore.models.MyOrders

class MyOrdersAdapter(private var list: ArrayList<MyOrders>) :
    RecyclerView.Adapter<MyOrdersAdapter.OrderViewHolder>() {

    private lateinit var onItemClick: OnItemClick

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyOrdersAdapter.OrderViewHolder {
        val binding: ListMyOrdersBinding =
            ListMyOrdersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyOrdersAdapter.OrderViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.onItemClickListeners(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }

    inner class OrderViewHolder(private val binding: ListMyOrdersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(myOrder: MyOrders) {
            binding.tvOrderNum.text = myOrder.orderNum
            binding.tvDateOrderValue.text = myOrder.deliver
            binding.tvDateStatusValue.text = myOrder.date
        }

        fun onItemClickListeners(myOrder: MyOrders) {
            binding.root.setOnClickListener {
                onItemClick.onClick(myOrder)
            }
        }
    }

    interface OnItemClick {
        fun onClick(myOrder: MyOrders)
    }
}