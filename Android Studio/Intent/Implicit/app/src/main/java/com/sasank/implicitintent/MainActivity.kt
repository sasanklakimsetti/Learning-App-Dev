package com.sasank.implicitintent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
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
        val btnDial=findViewById<Button>(R.id.openDialer)
        btnDial.setOnClickListener{
            val phnNum="tel:8371579171"  // tel: it means that we are entering a mobile number as a value
            val dialIntent=Intent(Intent.ACTION_DIAL)  // this will help to dial the number
            dialIntent.data=Uri.parse(phnNum)
            startActivity(dialIntent)  // this will
        }
        val urlBtn=findViewById<Button>(R.id.openAmazon)
        urlBtn.setOnClickListener{
            val url="https://www.amazon.in/"
            val urlIntent=Intent(Intent.ACTION_VIEW)
            urlIntent.data=Uri.parse(url)
            startActivity(urlIntent)
        }

    }
}