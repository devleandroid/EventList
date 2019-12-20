package com.br.lebronx.myrecyclerview

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.br.lebronx.myrecyclerview.Adapter.RecyclerAdapter
import com.br.lebronx.myrecyclerview.Adapter.TypesAdapter
import com.br.lebronx.myrecyclerview.Interface.ApiInterface
import com.br.lebronx.myrecyclerview.Interface.ApiInterface2
import com.br.lebronx.myrecyclerview.Model.Event
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var progerssProgressDialog: ProgressDialog
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerAdapter = RecyclerAdapter(this)
        recyclerview.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        recyclerView.adapter = recyclerAdapter

        progerssProgressDialog=ProgressDialog(this)
        progerssProgressDialog.setTitle("Carregando ... ")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()


        getResultTypes()

    }

    fun getResultTypes(){
        val apiService = ApiInterface.create().getResults()

        apiService.enqueue(object : Callback<List<Event>>{
            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                if (response?.body() != null)
                    recyclerAdapter.setListItems(response.body())
                else
                    Toast.makeText(applicationContext, response.toString(), Toast.LENGTH_LONG).show()
                    Log.d("Error_Response", response.toString())
                progerssProgressDialog.dismiss()
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                progerssProgressDialog.dismiss()
                call.toString()
                Log.d("Error_Response", "throwable: " + t.toString() + " - call_error: " + call.toString())
            }
        })
    }
}
