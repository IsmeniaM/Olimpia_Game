package com.example.olimpia.data

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.olimpia.*
import com.example.olimpia.data.db.PlayerEntity
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_data.view.*
import kotlinx.android.synthetic.main.activity_result_country.*
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import java.util.ArrayList

class RecyclerViewAdapter (val listener: RowClicklistener): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<PlayerEntity>()

    fun setListData(data: ArrayList<PlayerEntity>) {
        this.items = data

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row,parent,false)
        return MyViewHolder(inflater, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder( holder: MyViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener.onItemClickListener( items[position])

        }
        holder.bind(items[position])
    }

    class MyViewHolder(view: View, val listener: RowClicklistener): RecyclerView.ViewHolder(view) {
        val tvName = view.tvName
        val tvEmail = view.tvEmail
        val tvScoreData = view.tvScoreData

        val deletePlayerID = view.deletePlayerID


        fun bind (data: PlayerEntity) {

            tvName.text = data.name
            tvEmail.text = data.email
            tvScoreData.text = data.score


            deletePlayerID.setOnClickListener {
                listener.onDeletePlayerClickListener(data)

            }

        }
    }



    interface RowClicklistener {

        fun onDeletePlayerClickListener(player: PlayerEntity)
        fun onItemClickListener(player: PlayerEntity)

    }
}


