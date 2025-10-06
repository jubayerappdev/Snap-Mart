package com.creativeitinstitute.snapmart.views.login

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.snapmart.R
import com.creativeitinstitute.snapmart.base.BaseFragment
import com.creativeitinstitute.snapmart.databinding.FragmentLoginBinding
import com.creativeitinstitute.snapmart.isEmpty

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun setListener() {


        with(binding){
            btnLogin.setOnClickListener {

                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etEmail.isEmpty() && !etPassword.isEmpty()){

                    Toast.makeText(context, "All input done!", Toast.LENGTH_LONG).show()

                }
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }
        }
    }

    override fun allObserver() {


    }

}