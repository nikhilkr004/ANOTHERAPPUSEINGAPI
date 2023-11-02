package com.example.anotherappuseingapi

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter (val context:Activity, val userData:List<User>)
    :RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)

        var  age = itemView.findViewById<TextView>(R.id.age)

        var  gender = itemView.findViewById<TextView>(R.id.gender)

        var image = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val hello = LayoutInflater.from(parent.context).inflate(R.layout.each_data, parent, false)
        return  ViewHolder(hello)
    }

    override fun getItemCount(): Int {

        return  userData.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   var currentPosition = userData[position]

    holder.name.text= "Name :"+currentPosition.firstName
        holder.age.text= "Age :"+currentPosition.age.toString()

        holder.gender.text= "Gender :"+currentPosition.gender.toString()


        ////image
        Picasso.get().load(currentPosition.image).into(holder.image);

    }
}