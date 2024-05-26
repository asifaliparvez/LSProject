package com.example.lsproject.Package

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lsproject.R
import com.example.lsproject.databinding.FragmentMorningResultBinding


class MorningResultFragment : Fragment() {
    private lateinit var binding:FragmentMorningResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val morning = requireArguments().getString("morning")
        Toast.makeText(requireContext(), morning, Toast.LENGTH_SHORT).show()
        binding = FragmentMorningResultBinding.inflate(inflater, container, false)
        Glide.with(requireContext()).load(morning).into(binding.imageView)

        return inflater.inflate(R.layout.fragment_morning_result, container, false)
    }

}