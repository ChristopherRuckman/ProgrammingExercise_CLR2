package com.example.programmingexercise_clr.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShoppingBag(@SerializedName("products")val products: List<Product>,
                       @SerializedName("promos")val promos: List<Promos>,
                       @SerializedName("summary")val summary: Summary) : Parcelable


@Parcelize
data class Product(@SerializedName("sku")val sku: String,
                   @SerializedName("displayName")val displayName: String,
                   @SerializedName("price")val price: String,
                   @SerializedName("quantity")val quantity: Int) : Parcelable

@Parcelize
data class Promos(@SerializedName("code")val code: String,
                  @SerializedName("description")val description: String,
                  @SerializedName("value")val value: String) : Parcelable

@Parcelize
data class Summary(@SerializedName("subtotal")val subtotal: String,
                   @SerializedName("tax")val tax: String,
                   @SerializedName("discounts")val discounts: String,
                   @SerializedName("total") val total: String) : Parcelable
