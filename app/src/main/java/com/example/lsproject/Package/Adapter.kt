package com.example.lsproject.Package

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lsproject.databinding.ItemLayoutBinding
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class Adapter(
    options: FirebaseRecyclerOptions<ResultModel>,
    ):FirebaseRecyclerAdapter<ResultModel, Adapter.MyViewHolder>(options){

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



    }


}