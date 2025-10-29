package com.creativeitinstitute.snapmart.views.dashboard.seller.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.creativeitinstitute.snapmart.R
import com.creativeitinstitute.snapmart.base.BaseFragment
import com.creativeitinstitute.snapmart.core.DataState
import com.creativeitinstitute.snapmart.data.models.Product
import com.creativeitinstitute.snapmart.databinding.FragmentMyProductBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyProductFragment : BaseFragment<FragmentMyProductBinding>(FragmentMyProductBinding::inflate) {

    private val viewModel: ProductViewModel by viewModels()

    override fun setListener() {

        FirebaseAuth.getInstance().currentUser?.let {

            viewModel.getProductByID(it.uid)
        }


    }

    override fun allObserver() {
        viewModel.productResponse.observe(viewLifecycleOwner){
            when(it) {
                is DataState.Error -> {
                    loading.dismiss()
                }
                is DataState.Loading -> {
                    loading.show()
                }
                is DataState.Success -> {
                    it.data?.let { it1->
                        setDataToRV(it1)
                    }
                    loading.dismiss()
                }
            }
        }


    }

    private fun setDataToRV(it: List<Product>) {

        binding.rvSeller.adapter = SellerProductAdapter(it)

    }


}