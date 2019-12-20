package com.br.lebronx.myrecyclerview.Api

import com.br.lebronx.myrecyclerview.Interface.ApiInterface.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    var BASE_URL: String = ""

    companion object {
        fun getClient(): ApiClient{

            var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(ApiClient::class.java)
        }
    }

}