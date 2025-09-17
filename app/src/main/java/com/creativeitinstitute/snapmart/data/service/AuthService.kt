package com.creativeitinstitute.snapmart.data.service

import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {

    fun userRegistration(user: UserRegister): Task<AuthResult>
    fun userLogin()

}