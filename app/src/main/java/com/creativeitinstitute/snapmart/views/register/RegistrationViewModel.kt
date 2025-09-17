package com.creativeitinstitute.snapmart.views.register

import android.util.Log
import androidx.lifecycle.ViewModel
import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.creativeitinstitute.snapmart.data.repository.AuthRepository

class RegistrationViewModel : ViewModel() {



    fun userRegistration(user: UserRegister){

        val authService = AuthRepository()

        authService.userRegistration(user).addOnSuccessListener {

            Log.d("TAG", "userRegistration: Success")
        }.addOnFailureListener {error->
            Log.d("TAG", "userRegistration: ${error.message}")
        }

    }





}