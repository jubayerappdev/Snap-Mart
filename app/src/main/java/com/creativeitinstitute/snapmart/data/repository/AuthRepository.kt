package com.creativeitinstitute.snapmart.data.repository

import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.creativeitinstitute.snapmart.data.service.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthRepository : AuthService {

    override fun userRegistration(user: UserRegister): Task<AuthResult> {

        val jAuth = FirebaseAuth.getInstance()

     return jAuth.createUserWithEmailAndPassword(user.email,user.password)

    }

    override fun userLogin() {


    }
}