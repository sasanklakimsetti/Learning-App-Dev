package com.sasank.gridview

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var gridItems: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        gridItems=findViewById(R.id.gridItems)
        val contact=listOf(
            Contact("Sasank","9133931410"),
            Contact("Rishith","8317579171"),
            Contact("Yuvaraj","8978987389")
        )

        val adapter= ContactAdapter(this, contact)
        gridItems.adapter=adapter
    }
}