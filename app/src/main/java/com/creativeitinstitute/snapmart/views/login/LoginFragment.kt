package com.creativeitinstitute.snapmart.views.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.snapmart.R
import com.creativeitinstitute.snapmart.base.BaseFragment
import com.creativeitinstitute.snapmart.core.DataState
import com.creativeitinstitute.snapmart.data.models.UserLogin
import com.creativeitinstitute.snapmart.databinding.FragmentLoginBinding
import com.creativeitinstitute.snapmart.isEmpty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels ()

    override fun setListener() {


        with(binding){
            btnLogin.setOnClickListener {

                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etEmail.isEmpty() && !etPassword.isEmpty()){

                    val user = UserLogin(
                        etEmail.text.toString(),
                        etPassword.text.toString()

                    )
                    viewModel.userLogin(user)


                }
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }
        }
    }

    override fun allObserver() {

        viewModel.loginResponse.observe(viewLifecycleOwner){

            when(it) {
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading->
                {
                    loading.show()
//                    Toast.makeText(context, "Loading.....", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success-> {
                    loading.dismiss()
                    Toast.makeText(context, "created User : ${it.data}", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                }
            }
        }

    }

}