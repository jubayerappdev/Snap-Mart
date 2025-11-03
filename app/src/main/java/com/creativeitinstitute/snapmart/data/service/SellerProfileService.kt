package com.creativeitinstitute.snapmart.data.service

import android.net.Uri
import com.creativeitinstitute.snapmart.data.models.Profile
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.UploadTask


interface SellerProfileService {

    fun uploadImage(productImageUri: Uri): UploadTask

    fun updateUser(user: Profile): Task<Void>

    fun getUserByUserID(userID: String): Task<QuerySnapshot>
}