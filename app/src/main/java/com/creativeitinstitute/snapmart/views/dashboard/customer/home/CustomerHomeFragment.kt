package com.creativeitinstitute.snapmart.views.dashboard.customer.home

import androidx.fragment.app.viewModels
import com.creativeitinstitute.snapmart.base.BaseFragment
import com.creativeitinstitute.snapmart.core.DataState
import com.creativeitinstitute.snapmart.data.models.Product
import com.creativeitinstitute.snapmart.databinding.FragmentCustomerHomeBinding
import com.creativeitinstitute.snapmart.views.dashboard.seller.product.SellerProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerHomeFragment : BaseFragment<FragmentCustomerHomeBinding>(FragmentCustomerHomeBinding::inflate) {

    private val viewModel: CustomerProductViewModel by viewModels ()

    override fun setListener() {


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

        binding.rvCustomerProduct.adapter = CustomerProductAdapter(it)

    }

}