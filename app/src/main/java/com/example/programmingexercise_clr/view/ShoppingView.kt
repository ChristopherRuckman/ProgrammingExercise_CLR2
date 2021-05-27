package com.example.programmingexercise_clr.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.programmingexercise_clr.CustomApplication
import com.example.programmingexercise_clr.R
import com.example.programmingexercise_clr.databinding.ShoppingBagLayoutBinding
import com.example.programmingexercise_clr.model.RepositoryImpl
import com.example.programmingexercise_clr.model.Summary
import com.example.programmingexercise_clr.view.adapter.ProductAdapter
import com.example.programmingexercise_clr.view.adapter.PromoAdapter
import com.example.programmingexercise_clr.viewmodel.UserViewModel
import com.example.programmingexercise_clr.viewmodel.UserViewModelProvider
import javax.inject.Inject

class ShoppingView : AppCompatActivity()  {

    @Inject lateinit var repository: RepositoryImpl
    @Inject lateinit var viewmodelProvider: UserViewModelProvider

    private val shoppingModel: UserViewModel by lazy {
        viewmodelProvider.create(UserViewModel::class.java)
    }
    //...
    private lateinit var binding: ShoppingBagLayoutBinding
    private val productAdapter: ProductAdapter by lazy {
        ProductAdapter()
    }
    private val promoAdapter: PromoAdapter by lazy {
        PromoAdapter()
    }
    //Create and bind to ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CustomApplication.component.inject(this)

        binding = ShoppingBagLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        //call shopping view model list of product and promos then call, object summary
        //data to update text views
        updateShoppingViewModel()
    }

    private fun setUpClickListeners() {
        //...
    }

    private fun updateShoppingViewModel() {
        //will fetch list from viewmodel and get all the information to update
        //text vew to display name, prices, promos and etc
        shoppingModel.data.observe(this){
            productAdapter.updateProducts(it.products)
            promoAdapter.updatePromo(it.promos)
        }
    }

    private fun initViews(){
        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(this@ShoppingView, RecyclerView.VERTICAL, false)
            adapter = productAdapter
        }

        binding.rvPromos.apply {
            layoutManager = LinearLayoutManager(this@ShoppingView, RecyclerView.VERTICAL, false)
            adapter = promoAdapter
        }
    }

    private fun initSummaryView(summary: Summary){
        binding.tvDiscounts.text = summary.discounts
        binding.tvSubtotal.text = summary.subtotal
        binding.tvTax.text = summary.tax
        binding.tvTotal.text = summary.total
    }
}
