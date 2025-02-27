package com.sasank.customtoast

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// custom toast can have images, icon, emojis
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.btn1)
        btn.setOnClickListener {
            Toast.makeText(this,"Hello😊😊",Toast.LENGTH_SHORT).show()  // win + . to see emoji pack
        }

        // custom toast with icon/ image
        val btn2=findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            showToast()
        }
    }
    fun showToast(){
        val inflater:LayoutInflater=layoutInflater
        val view:View=inflater.inflate(R.layout.toast_item,findViewById(R.id.toast_group))
        val toast:Toast=Toast(this)
        toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL,0,0)
        toast.duration=Toast.LENGTH_SHORT
        toast.view=view
        toast.show()
    }
}