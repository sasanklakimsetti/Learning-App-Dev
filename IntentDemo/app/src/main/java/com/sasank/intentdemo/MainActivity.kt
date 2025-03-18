package com.sasank.intentdemo

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
        val btn=findViewById<Button>(R.id.explicitBtn)
        btn.setOnClickListener {
            val explicitIntent= Intent(this, SecondActivity::class.java)
            startActivity(explicitIntent)
            finish()
        }

        val url="https://www.google.co.in/"
        val btn2=findViewById<Button>(R.id.implicitBtn)
        btn2.setOnClickListener {
            val implicitIntent= Intent(Intent.ACTION_VIEW,Uri.parse(url))
            startActivity(implicitIntent)
            finish()
        }
    }
}