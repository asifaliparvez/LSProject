package com.example.lsproject.Package

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lsproject.R
import com.example.lsproject.databinding.ItemLayoutBinding
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class Adapter(
    private val navController: NavController,
    options: FirebaseRecyclerOptions<ResultModel>,
    ):FirebaseRecyclerAdapter<ResultModel, Adapter.MyViewHolder>(options){

//Hello
    inner class  MyViewHolder( val binding:ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun setDate(date:String){
            binding.textView.text = date

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: ResultModel) {
        holder.setDate(model.date.toString())

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("date", model.date)
            bundle.putString("morning", model.morning)
            bundle.putString("evening", model.evening)
            bundle.putString("night", model.night)
            navController.navigate(R.id.action_oldResult_to_resultDetailFragment, bundle)

        }



    }


}