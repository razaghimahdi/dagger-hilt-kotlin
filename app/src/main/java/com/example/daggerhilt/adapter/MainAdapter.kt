package com.example.daggerhilt.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilt.R
import com.example.daggerhilt.model.InfoMain
import com.example.daggerhilt.ui.*

class MainAdapter(
    private val context: Context,
    private val data: List<InfoMain>
) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.title.text = data[position].title

        holder.itemView.setOnClickListener {
            when(position){
                0->context.startActivity(Intent(context, Part01Activity::class.java))
                1->context.startActivity(Intent(context, Part02Activity::class.java))
                2->context.startActivity(Intent(context, Part03Activity::class.java))
                3->context.startActivity(Intent(context, Part04Activity::class.java))
                4->context.startActivity(Intent(context, Part05Activity::class.java))
                5->context.startActivity(Intent(context, Part06Activity::class.java))
            }
        }


    }

    override fun getItemCount(): Int = data.count()


    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.list_nav_title)
    }

}