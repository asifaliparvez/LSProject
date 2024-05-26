package com.example.lsproject.Package

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lsproject.databinding.FragmentOldResultBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.UUID

class OldResult : Fragment() {
    private lateinit var adapter: Adapter
    private lateinit var binding: FragmentOldResultBinding
    private val dataBase = Firebase.database.reference
    private val TAG = "OldFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOldResultBinding.inflate(inflater, container, false)

        /*
        // Inflate the layout for this fragment
        val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy ")

        val date = Date()
        val strDate: String = dateFormat.format(date).toString()
        val ref = dataBase.root.child("results")
        ref.push().setValue(ResultModel(strDate, "morning","evening","night")).addOnCompleteListener {
            if (it.isSuccessful){
            }else{
                Log.d(TAG, it.exception.toString())
            }
        }
            .addOnFailureListener {
                Log.d(TAG, it.message.toString())
            }

         */



        setUpRecyclerView()
        return binding.root
    }

    private fun makeToast(text:String){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()


    }


    private fun setUpRecyclerView(){

        val query = FirebaseDatabase.getInstance().reference.child("oldresult")

        val options = FirebaseRecyclerOptions.Builder<ResultModel>()
            .setLifecycleOwner(this)
            .setQuery(query, ResultModel::class.java)

            .build()
        adapter = Adapter(navController = findNavController(),options)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = this.adapter

        binding.recyclerView.visibility = View.VISIBLE
        binding.textViewLoading.visibility = View.GONE

    }

}