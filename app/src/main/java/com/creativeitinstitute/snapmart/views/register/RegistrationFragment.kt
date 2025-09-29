package com.creativeitinstitute.snapmart.views.register

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.snapmart.R
import com.creativeitinstitute.snapmart.core.DataState
import com.creativeitinstitute.snapmart.data.models.UserRegister
import com.creativeitinstitute.snapmart.databinding.FragmentRegistrationBinding
import com.creativeitinstitute.snapmart.isEmpty


class RegistrationFragment : Fragment() {
    lateinit var binding: FragmentRegistrationBinding

    private val viewModel : RegistrationViewModel by viewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        setListener()
        registrationObserver()
        return binding.root
    }



    private fun setListener() {

        with(binding){
            btnRegister.setOnClickListener {
                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()){

                    Toast.makeText(context, "All input done!", Toast.LENGTH_LONG).show()

                    val user = UserRegister(
                        etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        "Seller",
                        ""
                    )

                    viewModel.userRegistration(user)



                }




            }
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
            }
        }
    }
    private fun registrationObserver() {

        viewModel.registrationResponse.observe(viewLifecycleOwner){

            when(it) {
                is DataState.Error -> {

                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading->
                {

                    Toast.makeText(context, "Loading....", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success-> {

                    Toast.makeText(context, "created User : ${it.data}", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(R.id.action_registrationFragment_to_dashboardFragment)
                }
            }
        }


    }


}