package com.example.lsproject.Package

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lsproject.R
import com.example.lsproject.databinding.FragmentBlankHomesreenBinding
import com.google.firebase.auth.FirebaseAuth

class Homescreen : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var navcontroll: NavController
    private lateinit var binding: FragmentBlankHomesreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankHomesreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        registerevents()

    }

    private fun registerevents() {
        binding.morning1pm.setOnClickListener {
            navcontroll.navigate(R.id.action_homescreen_to_morning1pm)
        }
            binding.Nanalysis.setOnClickListener {
                navcontroll.navigate(R.id.action_homescreen_to_numberanalysis)
            }
                binding.Oldresult.setOnClickListener {
                    navcontroll.navigate(R.id.action_homescreen_to_morningDayNightold)
                }
                    binding.barchart.setOnClickListener {
                        navcontroll.navigate(R.id.action_homescreen_to_barChartFragment)

        }
    }

    private fun init(view: View) {
        navcontroll = Navigation.findNavController(view)
        auth = FirebaseAuth.getInstance()
    }
}


