package com.creativeitinstitute.snapmart.data.models

data class UserRegister(
    val name: String,
    val email: String,
    val password:String,
    val userType: String,
    var userID: String
)
