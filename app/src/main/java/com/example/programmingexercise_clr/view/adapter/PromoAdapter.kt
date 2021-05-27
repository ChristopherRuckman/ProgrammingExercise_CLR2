package com.example.programmingexercise_clr.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.programmingexercise_clr.R
import com.example.programmingexercise_clr.databinding.PromoLayoutBinding
import com.example.programmingexercise_clr.model.Promos

class PromoAdapter(private var promos: List<Promos>? = null) : RecyclerView.Adapter<PromoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoAdapter.ViewHolder {
        val binding = PromoLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromoAdapter.ViewHolder, position: Int) {
        promos?.let { holder.onBind(it[position]) }
    }

    override fun getItemCount(): Int {
        return promos?.size ?: 0
    }

    fun updatePromo(promos: List<Promos>) {
        this.promos = promos
    }

    inner class ViewHolder(private val binding: PromoLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataItem: Promos){
            binding.tvCode.text = dataItem.code
            binding.tvDescription.text = dataItem.description
            binding.tvValue.text = dataItem.value
        }
    }
}