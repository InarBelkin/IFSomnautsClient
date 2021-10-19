package com.example.ifsomnauts.additional

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ifsomnauts.R
import com.example.ifsomnauts.models.Skill

class SkillsRecyclerAdapter(private val characteristics: ArrayList<Skill>) :
    RecyclerView.Adapter<SkillsRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cName: TextView? = null
        var cCount: TextView? = null

        init {
            cName = itemView.findViewById(R.id.characteristic_name)
            cCount = itemView.findViewById(R.id.characteristic_count)
        }

    }

    override fun getItemCount(): Int {
        return characteristics.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.skill_layout, parent, false)
        return MyViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cName?.text = characteristics[position].name.toString();
        holder.cCount?.text = characteristics[position].count.toString();

    }


}