package com.creativeitinstitute.snapmart.views.dashboard.seller.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.creativeitinstitute.snapmart.data.models.Product
import com.creativeitinstitute.snapmart.databinding.ItemSellerProductBinding

class SellerProductAdapter(val productList: List<Product>) : RecyclerView.Adapter<SellerProductAdapter.ProductViewHolder> (){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        return ProductViewHolder(ItemSellerProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {
        productList[position].let {
            holder.binding.apply {
                txtProductName.text = it.name
                txtProductDescription.text = it.description
                txtProductPrice.text = "Price: $ ${it.price}"
                txtProductStock.text = "Stock: $ ${it.amount}"
                ivProduct.load(it.imageLink)
            }
        }


    }

    override fun getItemCount(): Int {

        return productList.size

    }

    class ProductViewHolder(val binding: ItemSellerProductBinding) : RecyclerView.ViewHolder(binding.root)
}