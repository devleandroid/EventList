package com.br.lebronx.myrecyclerview.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.br.lebronx.myrecyclerview.AboutEvent
import com.br.lebronx.myrecyclerview.Model.Event
import com.br.lebronx.myrecyclerview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.recylcerview_adapter.view.*

class RecyclerAdapter(var context: Context): RecyclerView.Adapter<RecyclerAdapter.rViewHolder>() {

    var resultList : List<Event> = listOf()

    lateinit var mClickListener: ClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recylcerview_adapter, parent, false)
        return rViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: rViewHolder, position: Int) {
        holder.txtName.text = resultList.get(position).title

        Glide.with(context).load(resultList.get(position).image)
                .apply(RequestOptions().centerCrop())
                .into(holder.txtImage)

        // Old method for click in recyclerview
       holder.itemView.image.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                showToas(context, holder.txtName.text.toString())
                val description = resultList.get(position).description
                val intent = Intent(context, AboutEvent::class.java)
                intent.putExtra("description", description)
                context.startActivity(intent)
            }
       })
    }

    private fun showToas(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    inner class rViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val txtName: TextView = itemView!!.findViewById(R.id.name)
        val txtImage: ImageView = itemView!!.findViewById(R.id.image)

        override fun onClick(v:View){
            mClickListener.onClick(position, v)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

    fun setListItems(listResults: List<Event>?){
        this.resultList = listResults!!
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(aClickListener: ClickListener) {
        mClickListener = aClickListener
    }

    interface ClickListener {
        fun onClick(pos: Int, aView: View)
    }
}





