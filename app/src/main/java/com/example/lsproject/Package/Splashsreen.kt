package com.example.lsproject.Package

import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lsproject.R
import java.util.logging.Handler

class Splashsreen : Fragment() {
    private lateinit var navcontrol: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_splashsreen, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navcontrol=  Navigation.findNavController(view)
        android.os.Handler(Looper.myLooper()!!).postDelayed(Runnable{
        navcontrol.navigate(R.id.action_splashsreen_to_homescreen)
        },2000)
    }
}
