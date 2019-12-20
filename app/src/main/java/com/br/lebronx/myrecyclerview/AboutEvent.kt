package com.br.lebronx.myrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView



class AboutEvent : AppCompatActivity() {
    var txt_description : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        var bundle :Bundle ?=intent.extras
        var description = bundle!!.getString("description")

        txt_description = findViewById<TextView>(R.id.description)

        txt_description!!.text = description

    }
}