package com.example.ifsomnauts.additional

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ifsomnauts.R
import com.example.ifsomnauts.models.Characteristic
import com.example.ifsomnauts.models.dialog.Replica


class ReplicaAdapter(private val characteristics: ArrayList<Replica>) :
    RecyclerView.Adapter<ReplicaAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var speakerTv: TextView? = null
        var phraseTv: TextView? = null

        init {
            speakerTv = itemView.findViewById(R.id.replica_speaker)
            phraseTv = itemView.findViewById(R.id.characteristic_count);
        }

    }

    override fun getItemCount(): Int {
        return characteristics.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.replica_layout, parent, false)
        return MyViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.speakerTv?.text = characteristics[position].speaker + ":";
        holder.phraseTv?.text = characteristics[position].phrase;
    }


}