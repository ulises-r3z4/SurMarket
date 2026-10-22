package com.example.surmarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product


class AdapterProducts (
    private val productsList: List<product>,
    private val clickOnBuy: (product) -> Unit
) : RecyclerView.Adapter<AdapterProducts.ViewHolderProduct>() {

    //========================================
    class ViewHolderProduct(itemView: View): RecyclerView.ViewHolder(itemView) {
        val TXV_FRGProductsList_Category: TextView =
            itemView.findViewById(R.id.TXV_FRGProductsList_Category)
        val TXV_FRGProductsList_ProductName: TextView =
            itemView.findViewById(R.id.TXV_FRGProductsList_ProductName)
        val TXV_FRGProductsList_Price: TextView =
            itemView.findViewById(R.id.TXV_FRGProductsList_Price)
        val BTN_ITProductList_Buy: Button =
            itemView.findViewById(R.id.BTN_ITProductList_Buy)
        val IMV_FRGProductsList_ProductImage: ImageView =
            itemView.findViewById(R.id.IMV_FRGProductsList_ProductImage)
        val stringCategory=itemView.context.getString(R.string.category)
        val stringPrice=itemView.context.getString(R.string.price)
    }
    //========================================

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProducts.ViewHolderProduct {
       val vista= LayoutInflater.from(parent.context).inflate(R.layout.item_productslist,parent,false)
        return ViewHolderProduct(vista)
    }

    override fun onBindViewHolder(holder: AdapterProducts.ViewHolderProduct, position: Int) {
        val product=productsList[position]
        holder.TXV_FRGProductsList_Category.text = holder.stringCategory+": "+product.category
        holder.TXV_FRGProductsList_ProductName.text=product.name
        holder.TXV_FRGProductsList_Price.text=holder.stringPrice+": "+"${product.price}"
        holder.IMV_FRGProductsList_ProductImage.setImageResource(R.drawable.surmarket)
        holder.BTN_ITProductList_Buy.setOnClickListener {
            clickOnBuy(product)
        }
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    fun notifyChanged(){
        notifyDataSetChanged()
    }
}