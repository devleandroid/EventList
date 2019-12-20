package com.br.lebronx.myrecyclerview.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.br.lebronx.myrecyclerview.Model.Event
import com.br.lebronx.myrecyclerview.R

class TypesAdapter (var context: Context): RecyclerView.Adapter<TypesAdapter.ViewHolder>() {

    var resultList : List<Event> = listOf()

    lateinit var resultEvent : Event

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.typesview_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, positon: Int) {
        holder.name.text = resultList.get(positon).title
        holder.description.text = resultList.get(positon).description
        /*Glide.with(context)
                .load(resultList.get(positon).image).apply(RequestOptions().centerCrop())
                .into(holder.thumbnailImage)*/
    }


    inner class ViewHolder (itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        val name : TextView = itemView!!.findViewById(R.id.name)
        val description :TextView = itemView!!.findViewById(R.id.description)
        val thumbnailImage : ImageView = itemView!!.findViewById(R.id.image)
    }

    fun setListItems(listResults: List<Event>?){
        this.resultList = listResults!!
        notifyDataSetChanged()
    }

    fun setItem(result: Event){
        this.resultEvent = result
        notifyDataSetChanged()
    }
}