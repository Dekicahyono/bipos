package com.project.bipos.presentation.order_status

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.bipos.R
import com.project.bipos.model.Order
import kotlinx.android.synthetic.main.item_order.view.*
import kotlinx.android.synthetic.main.item_order.view.img_product
import kotlinx.android.synthetic.main.item_order.view.tv_productName
import kotlinx.android.synthetic.main.item_order.view.tv_productPrice
import kotlinx.android.synthetic.main.item_order_status.view.*

class OrderStatusAdapter(private val onItemClicked: (product: Order) -> Unit) :
    RecyclerView.Adapter<OrderStatusAdapter.CartViewHolder>() {

    private val productList = mutableListOf<Order>()

    fun addItems(products: List<Order>) {
        productList.clear()
        productList.addAll(products)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_order_status, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holderHomeMenu: CartViewHolder, position: Int) {
        val order = productList[position]
        holderHomeMenu.bind(order)
        holderHomeMenu.itemView.setOnClickListener { onItemClicked(order) }
    }

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(product: Order) {
            Glide.with(itemView)
                .load(product.image)
                .into(itemView.img_product)
            itemView.tv_productName.text = product.productName
            itemView.tv_resiNumber.text = "No Resi : ${product.resiNumber}"
            itemView.tv_productPrice.text = "Rp.${product.totalPrice}"
        }

    }

}