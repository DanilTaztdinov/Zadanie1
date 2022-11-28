package com.bignerdranch.android.danilz1

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get

class MainActivity2 : AppCompatActivity() {
        lateinit var spin: Spinner
        lateinit var share: SharedPreferences
        lateinit var username: TextView
        lateinit var password: TextView
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main2)
            username=findViewById(R.id.TextView1)
            password=findViewById(R.id.TextView2)
            share=getSharedPreferences("q",MODE_PRIVATE)
            var Log = share.getString("log", "NONE")
            var pass = share.getString("pass", "NONE")
            username.setText(Log).toString()
            password.setText(pass).toString()
        }
}


