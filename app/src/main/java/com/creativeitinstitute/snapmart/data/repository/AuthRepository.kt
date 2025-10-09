package com.creativeitinstitute.snapmart.data.repository

import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.creativeitinstitute.snapmart.data.service.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthRepository  @Inject constructor(
    private val jAuth: FirebaseAuth
): AuthService {

    override fun userRegistration(user: UserRegister): Task<AuthResult> {



     return jAuth.createUserWithEmailAndPassword(user.email,user.password)

    }

    override fun userLogin() {



    }
}