package com.sasank.explicitintent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
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
        val btnGoToSecondActivity=findViewById<Button>(R.id.btnGoToSecondAcitivity)
        btnGoToSecondActivity.setOnClickListener{
            val intent=Intent(this,MainActivity2::class.java)  // the values inside the Intent describes the initial activity and to be redirected activity
            intent.putExtra("message","Hello from main activity")
            startActivity(intent)
        }
    }
}