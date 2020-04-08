package com.greimul.copy2message.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greimul.copy2message.R
import com.greimul.copy2message.db.History
import kotlinx.android.synthetic.main.item_copy_list.view.*

class MainAdapter():RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var viewData:List<History> = listOf()

    class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        val textDate:TextView = v.textview_copy_date
        val textCopy:TextView = v.textview_copy_text
    }

    override fun getItemCount(): Int = viewData.size

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.textDate.text = viewData[position].date
        holder.textCopy.text = viewData[position].copyText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val v:View = LayoutInflater.from(parent.context).inflate(R.layout.item_copy_list,parent,false)

        val viewHolder = ViewHolder(v)

        return viewHolder
    }

    fun setHistoryList(historyList:List<History>){
        viewData  = historyList
        notifyDataSetChanged()
    }
}