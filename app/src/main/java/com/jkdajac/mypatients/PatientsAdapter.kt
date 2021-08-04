package com.jkdajac.mypatients

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.android.synthetic.main.item_patient.view.*

class PatientsAdapter(val patients : ArrayList<Patient>, val context: Context, val callback: PatientsListCallback)
    : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_patient, parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = patients[position].name
        holder.lastname.text = patients[position].lastname
        holder.root.setOnClickListener {
            callback.onItemSelected(position)
        }
    }

    override fun getItemCount(): Int {
        return patients.size
    }
}

class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val name = itemView.tvNameList
    val lastname = itemView.tvLastNameList
    val root = itemView.clItemRoot


}

interface  PatientsListCallback{
    fun onItemSelected(index : Int)
}