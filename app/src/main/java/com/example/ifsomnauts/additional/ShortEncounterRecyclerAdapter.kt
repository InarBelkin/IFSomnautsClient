package com.example.ifsomnauts.additional

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ifsomnauts.R
import com.example.ifsomnauts.models.ShortEncounter
import com.example.ifsomnauts.models.Skill


class ShortEncounterRecyclerAdapter(
    private val characteristics: ArrayList<ShortEncounter>,
    private val changePageCallback: (Int) -> Unit
) :
    RecyclerView.Adapter<ShortEncounterRecyclerAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cName: TextView? = null

        init {
            cName = itemView.findViewById(R.id.encounter_name)
        }

    }

    override fun getItemCount(): Int {
        return characteristics.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.short_encounter_layout, parent, false)
        return MyViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cName?.text = characteristics[position].name.toString();

        holder.cName?.setOnClickListener {
            changePageCallback(2);
//            val text = "Пора покормить кота!"
//            val duration = Toast.LENGTH_SHORT
//
//            val toast = Toast.makeText(context, text, duration)
//            toast.show()

        }
    }


}