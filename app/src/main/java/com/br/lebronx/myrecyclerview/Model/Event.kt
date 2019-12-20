package com.br.lebronx.myrecyclerview.Model

data class Event (
        val people: List<Person>,
        val date: Long,
        var description: String,
        var image: String,
        val longitude: Double,
        val latitude: Double,
        val price: Double,
        var title: String,
        val id: String,
        val cupons: List<Cupon>
){
}