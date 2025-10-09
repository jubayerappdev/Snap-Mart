package com.creativeitinstitute.snapmart.views.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.creativeitinstitute.snapmart.core.DataState
import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.creativeitinstitute.snapmart.data.repository.AuthRepository
import com.google.firebase.firestore.auth.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val authService: AuthRepository) : ViewModel() {

    private val _registrationResponse = MutableLiveData<DataState<UserRegister>>()
    val registrationResponse: LiveData<DataState<UserRegister>> = _registrationResponse



    fun userRegistration(user: UserRegister){

        _registrationResponse.postValue(DataState.Loading())



        authService.userRegistration(user).addOnSuccessListener {

            _registrationResponse.postValue(DataState.Success(user))
            Log.d("TAG", "userRegistration: Success")
        }.addOnFailureListener {error->

            _registrationResponse.postValue(DataState.Error("${error.message}"))


            Log.d("TAG", "userRegistration: ${error.message}")
        }

    }


}