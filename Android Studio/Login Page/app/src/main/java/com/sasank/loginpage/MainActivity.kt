package com.sasank.loginpage

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var username=findViewById<EditText>(R.id.editText1)
        var password=findViewById<EditText>(R.id.editText2)
        var btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            if(username.text.toString()=="sasank"&&password.text.toString()=="Sasank9133"){
                Toast.makeText(this,username.text.toString()+" has logged in successfully!!",Toast.LENGTH_LONG)
                var textview1=username.text.toString()
                btn.text="logged in"
            }
        }
    }
}