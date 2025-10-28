package com.creativeitinstitute.snapmart.data.service

import android.net.Uri
import com.creativeitinstitute.snapmart.data.models.Product
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.UploadTask

interface SellerService {

    fun uploadProductImage(productImageUri: Uri): UploadTask
    fun uploadProduct(product: Product): Task<Void>


}