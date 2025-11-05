package com.creativeitinstitute.snapmart.views.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.creativeitinstitute.snapmart.core.DataState
import com.creativeitinstitute.snapmart.data.models.Product
import com.creativeitinstitute.snapmart.data.models.Profile
import com.creativeitinstitute.snapmart.data.models.UserLogin
import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.creativeitinstitute.snapmart.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authService: AuthRepository) : ViewModel() {

    private val _loginResponse = MutableLiveData<DataState<Profile>>()
    val loginResponse: LiveData<DataState<Profile>> = _loginResponse



    fun userLogin(user: UserLogin){

        _loginResponse.postValue(DataState.Loading())



        authService.userLogin(user).addOnSuccessListener {


            Log.d("TAG", "userRegistration: Success")
            checkUserByID(it.user?.uid)
        }.addOnFailureListener {error->

            _loginResponse.postValue(DataState.Error("${error.message}"))


            Log.d("TAG", "userRegistration: ${error.message}")
        }

    }

    private fun checkUserByID(uid: String?) {

        uid?.let { userID->
            authService.getUserByUserID(userID).addOnSuccessListener {value->
                _loginResponse.postValue(DataState.Success(
                    value.documents[0].toObject(
                        Profile::class.java
                    )

                ))

            }.addOnFailureListener {error->
                _loginResponse.postValue(DataState.Error("${error.message}"))
            }

        }

    }


}