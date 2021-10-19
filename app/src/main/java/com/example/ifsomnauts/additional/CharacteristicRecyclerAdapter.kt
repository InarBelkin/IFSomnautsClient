package com.example.ifsomnauts.additional

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ifsomnauts.R
import com.example.ifsomnauts.models.Characteristic

class CharacteristicRecyclerAdapter(private val characteristics: ArrayList<Characteristic>) :
    RecyclerView.Adapter<CharacteristicRecyclerAdapter.MyViewHolder>() {

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
                .inflate(R.layout.characteristic_layout, parent, false)
        return MyViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cName?.text = characteristics[position].name.toString();
        holder.cCount?.text = characteristics[position].count.toString() + "/" + characteristics[position].countMax.toString() ;

    }


}