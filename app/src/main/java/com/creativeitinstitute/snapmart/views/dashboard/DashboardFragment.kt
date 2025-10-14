package com.creativeitinstitute.snapmart.views.dashboard

import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.snapmart.R
import com.creativeitinstitute.snapmart.base.BaseFragment
import com.creativeitinstitute.snapmart.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {


    @Inject
    lateinit var jAuth: FirebaseAuth

    override fun setListener() {
        with(binding){
            btnLogout.setOnClickListener {
                jAuth.signOut()
                findNavController().navigate(R.id.action_dashboardFragment_to_startFragment)

            }
        }

    }

    override fun allObserver() {

    }


}