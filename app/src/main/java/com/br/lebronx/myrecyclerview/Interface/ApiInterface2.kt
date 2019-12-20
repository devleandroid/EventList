package com.br.lebronx.myrecyclerview.Interface


import com.br.lebronx.myrecyclerview.Model.Event
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface2 {

    @GET("/api/events/")
    fun getResults(): Call<List<Event>>

    @GET("/api/events/{id}")
    fun getResultsId(@Path("id")id:String): Call<List<Event>>

    @GET("/api/events/{id}")
    fun getResultId(@Path("id")id:String): Call<Event>

    companion object {
        var BASE_URL = "http://5b840ba5db24a100142dcd8c.mockapi.io"

        fun getClient(): ApiInterface2 {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(ApiInterface2::class.java)
        }
    }
}