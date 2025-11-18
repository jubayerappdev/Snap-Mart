package com.creativeitinstitute.snapmart.data.repository

import android.net.Uri
import com.creativeitinstitute.snapmart.core.Nodes
import com.creativeitinstitute.snapmart.data.models.Product
import com.creativeitinstitute.snapmart.data.models.UserLogin
import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.creativeitinstitute.snapmart.data.service.AuthService
import com.creativeitinstitute.snapmart.data.service.CustomerService
import com.creativeitinstitute.snapmart.data.service.SellerService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import javax.inject.Inject

class CustomerRepository  @Inject constructor(
    private val db: FirebaseFirestore,
    private val storageRef: StorageReference
): CustomerService {
    override fun uploadProductImage(productImageUri: Uri): UploadTask {

        val storage: StorageReference = storageRef.child("product").child("PRD_${System.currentTimeMillis()}")

     return storage.putFile(productImageUri)

    }

    override fun uploadProduct(product: Product): Task<Void> {
        return  db.collection(Nodes.PRODUCT).document(product.productID).set(product)
    }

    override fun getAllProductByUserID(userID: String): Task<QuerySnapshot> {

      return db.collection(Nodes.PRODUCT).whereEqualTo("sellerID", userID).get()

    }

    override fun getAllProduct(): Task<QuerySnapshot> {

        return db.collection(Nodes.PRODUCT).get()
    }


}