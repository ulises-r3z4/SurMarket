package com.example.surmarket

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product

class AdapterProducts (
    private val productList: List<product>,
    private val clickOnBuy: (product) -> Unit
) : RecyclerView.Adapter<AdapterProducts.ViewHolderProduct>() {

    //========================================
    class ViewHolderProduct(){

    }

    //========================================

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProducts.ViewHolderProduct {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AdapterProducts.ViewHolderProduct, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}