package com.sasank.appchooser

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnOpenChooser:Button=findViewById(R.id.chooseBtn)
        btnOpenChooser.setOnClickListener{
            openAppChooser()
        }
    }
    private fun openAppChooser(){
        // create an intent for viewing a webpage
        val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
        // create a chooser for the intent
        val chooser=Intent.createChooser(intent,"Choose an app to open this link")
        // start the chooser activity
        startActivity(chooser)

    }
}