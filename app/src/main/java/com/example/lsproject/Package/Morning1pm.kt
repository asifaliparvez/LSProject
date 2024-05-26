package com.example.lsproject.Package

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lsproject.R
import com.example.lsproject.databinding.FragmentMorning1pmBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Morning1pm : Fragment() {
    private lateinit var firebaseDatabase: DatabaseReference
    private lateinit var binding: FragmentMorning1pmBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMorning1pmBinding.inflate(inflater,container,false)
        firebaseDatabase = Firebase.database.reference
//        val model = MorningOnePmModel("asifali")
//        firebaseDatabase.child("morning1pm").setValue(model).addOnCompleteListener {
//            Toast.makeText(requireContext(), "Data added", Toast.LENGTH_LONG).show()
//        }
        firebaseDatabase.child("morning1pm").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              val value =   snapshot.getValue(MorningOnePmModel::class.java)
                if(snapshot.exists()){
                    Glide.with(requireContext()).load(value!!.url ).into(binding.imageView2)
                    Toast.makeText(requireContext(), value.url ?:"Data does not exists", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(requireContext(), value?.url?:"Data does not exists", Toast.LENGTH_LONG).show()
                }


            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("morning", error.message)

            }

        })

        return inflater.inflate(R.layout.fragment_morning1pm, container, false)

    }


}