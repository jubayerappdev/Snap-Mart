package com.creativeitinstitute.snapmart.views.dashboard.seller.product

import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.creativeitinstitute.snapmart.core.DataState
import com.creativeitinstitute.snapmart.data.models.Product
import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.creativeitinstitute.snapmart.data.repository.AuthRepository
import com.creativeitinstitute.snapmart.data.repository.SellerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repo: SellerRepository) : ViewModel() {

    private val _productResponse = MutableLiveData<DataState<List<Product>>>()
    val productResponse: LiveData<DataState<List<Product>>> = _productResponse


    fun getProductByID(userID: String){
        _productResponse.postValue(DataState.Loading())

        repo.getAllProductByUserID(userID).addOnSuccessListener { document->

            val productList = mutableListOf<Product>()

            document.documents.forEach { doc->

                doc.toObject(Product::class.java)?.let {
                    productList.add(it)
                }
            }

            _productResponse.postValue(DataState.Success(productList))

        }.addOnFailureListener {
            _productResponse.postValue(DataState.Error("${it.message}"))
        }

    }



}