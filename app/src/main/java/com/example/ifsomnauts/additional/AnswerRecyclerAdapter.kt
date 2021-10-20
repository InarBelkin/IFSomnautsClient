package com.example.ifsomnauts.additional

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ifsomnauts.R
import com.example.ifsomnauts.models.dialog.Answer


class AnswerRecyclerAdapter(private val answers: ArrayList<Answer>) :
    RecyclerView.Adapter<AnswerRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var phrase: TextView? = null

        init {
          phrase = itemView.findViewById(R.id.answer_phrase)
        }

    }

    override fun getItemCount(): Int {
        return answers.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.answer_layout, parent, false)
        return MyViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.phrase?.text = answers[position].phrase;

    }


}