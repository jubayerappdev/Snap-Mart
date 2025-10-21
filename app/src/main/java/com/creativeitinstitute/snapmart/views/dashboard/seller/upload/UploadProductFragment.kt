package com.creativeitinstitute.snapmart.views.dashboard.seller.upload

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.fragment.app.Fragment
import com.creativeitinstitute.snapmart.R
import com.creativeitinstitute.snapmart.base.BaseFragment
import com.creativeitinstitute.snapmart.core.areAllPermissionGranted
import com.creativeitinstitute.snapmart.core.extract
import com.creativeitinstitute.snapmart.core.requestPermission
import com.creativeitinstitute.snapmart.data.models.Product
import com.creativeitinstitute.snapmart.databinding.FragmentUploadProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UploadProductFragment : BaseFragment<FragmentUploadProductBinding>(
    FragmentUploadProductBinding::inflate
) {
    private lateinit var permissionsRequest: ActivityResultLauncher<Array<String>>
    lateinit var product: Product
    override fun setListener() {

        permissionsRequest = getPermissionRequest()

        binding.apply {
            ivProduct.setOnClickListener {
                requestPermission(permissionsRequest, permissionList)
            }

            btnUploadProduct.setOnClickListener {

                val name = etProductName.extract()
                val price = etProductPrice.extract()
                val description = etProductDescription.extract()
                val amount = etProductAmount.extract()

                product = Product(
                    name = name,
                    description = description,
                    price = price.toDouble(),
                    amount = amount.toInt()
                )

                uploadProduct(product)
            }
        }

    }

    private fun getPermissionRequest(): ActivityResultLauncher<Array<String>> {

        return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){

            if (areAllPermissionGranted(permissionList)){

                //ase
                Toast.makeText(requireContext(),"Ase", Toast.LENGTH_LONG).show()

            }else{
                //nai
                Toast.makeText(requireContext(),"Nai", Toast.LENGTH_LONG).show()
            }

        }


    }

    private fun uploadProduct(product: Product) {


    }

    override fun allObserver() {

    }

    companion object{
        private val permissionList = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
    }




}