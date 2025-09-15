package com.creativeitinstitute.snapmart

import android.widget.EditText


fun EditText.isEmpty(): Boolean{

    return if (this.text.toString().isEmpty()){
        this.error = "This Place Need to be Fill up"
        true
    }else{
        false
    }
}