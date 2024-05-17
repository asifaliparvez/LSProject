package com.example.lsproject.Package

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lsproject.R
import com.example.lsproject.databinding.FragmentResultDetailBinding


class ResultDetailFragment : Fragment() {
    private  lateinit var  binding : FragmentResultDetailBinding
    private lateinit var navcontrol : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val date = requireArguments().getString("date")
        val morning = requireArguments().getString("morning")
        val evening = requireArguments().getString("evening")
        val night = requireArguments().getString("night")

        binding = FragmentResultDetailBinding.inflate(inflater,container,false)


        binding.btnMorning.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("morning", morning)

            findNavController().navigate(R.id.action_resultDetailFragment_to_morningResultFragment,bundle)
        }


        return binding.root


    }



}