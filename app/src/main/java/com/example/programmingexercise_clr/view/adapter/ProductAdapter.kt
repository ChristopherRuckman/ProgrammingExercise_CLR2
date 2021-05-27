package com.example.programmingexercise_clr.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.programmingexercise_clr.R
import com.example.programmingexercise_clr.databinding.ProductLayoutBinding
import com.example.programmingexercise_clr.model.Product

class ProductAdapter(private var products: List<Product>? = null) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        products?.let {
            holder.onBind(it[position])
        }
    }

    override fun getItemCount(): Int {
        return products?.size ?: 0
    }

    fun updateProducts(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ProductLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataItem: Product) {
            binding.tvSku.text = dataItem.sku
            binding.tvDisplayName.text = dataItem.displayName
            binding.tvPrice.text = dataItem.price
            binding.tvQuantity.text = dataItem.quantity.toString()
        }
    }
}