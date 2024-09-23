package com.sasank.lpuloginpage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var a=findViewById<EditText>(R.id.usrid)
        var b=findViewById<EditText>(R.id.pass)
        var c=findViewById<Button>(R.id.button)
        c.setOnClickListener{
            if(a.text.toString()=="12209302"&&b.text.toString()=="ABCD"){
                Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show()
                c.text="Logged in"
            }
            else{
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show()
                c.text="Enter the password again"
            }
        }
    }
}