package com.sasank.explicitintent

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Message
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val msg=intent.getStringExtra("message")
        val textViewMessage=findViewById<TextView>(R.id.textView1)
        textViewMessage.text=msg
    }
}