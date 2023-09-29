package com.example.intagram.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.intagram.Models.Post
import com.example.intagram.databinding.MyPostRvDesignBinding
import com.google.api.Context
import com.squareup.picasso.Picasso

class MyPostRvAdapter (var context: android.content.Context, var postList: ArrayList<Post>):RecyclerView.Adapter<MyPostRvAdapter.ViewHolder>(){

    inner class ViewHolder(var binding: MyPostRvDesignBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = MyPostRvDesignBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get().load(postList.get(position).postUrl).into(holder.binding.postImage)
    }
}