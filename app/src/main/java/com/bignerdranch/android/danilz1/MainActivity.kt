package com.bignerdranch.android.danilz1

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var share: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login=findViewById(R.id.editText1)
        password=findViewById(R.id.editText2)
        share=getSharedPreferences("q", MODE_PRIVATE)
        if (share.contains("log") && share.contains("pass")){
            var log =share.getString("log", "NONE")
            var pass = share.getString("pass", "NONE")
            login.setText(log)
            password.setText(pass)
        }
    }

    fun b1(view: android.view.View){
        if(!share.contains("log") && !share.contains("pass")) {
            if (login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                var editing = share.edit()
                editing.putString("log", login.text.toString())
                editing.putString("pass", password.text.toString())
                editing.apply()
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            else {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка").setMessage("Поля не заполнены!")
                    .setPositiveButton("ok", null)
                    .create()
                    .show()
            }
        }
        else {
            var Log = share.getString("log", "NONE")
            var pass = share.getString("pass", "NONE")
            login.setText(Log)
            password.setText(pass)
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}