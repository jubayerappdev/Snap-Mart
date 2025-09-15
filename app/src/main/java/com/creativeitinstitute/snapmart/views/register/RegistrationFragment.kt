package com.creativeitinstitute.snapmart.views.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.snapmart.R
import com.creativeitinstitute.snapmart.databinding.FragmentRegistrationBinding
import com.creativeitinstitute.snapmart.isEmpty

class RegistrationFragment : Fragment() {
    lateinit var binding: FragmentRegistrationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        setListener()
        return binding.root
    }

    private fun setListener() {

        with(binding){
            btnRegister.setOnClickListener {
                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()


            }
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
            }
        }
    }


}