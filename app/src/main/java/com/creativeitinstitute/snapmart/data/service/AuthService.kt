package com.creativeitinstitute.snapmart.data.service

import com.creativeitinstitute.snapmart.data.models.UserLogin
import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.firestore.QuerySnapshot

interface AuthService {

    fun userRegistration(user: UserRegister): Task<AuthResult>
    fun userLogin(user: UserLogin): Task<AuthResult>
    fun createUser(user: UserRegister): Task<Void>
    fun getUserByUserID(userID: String): Task<QuerySnapshot>

}