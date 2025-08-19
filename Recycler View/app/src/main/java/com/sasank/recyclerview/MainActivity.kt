package com.sasank.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)
        val contacts=listOf(
            Contact("Sasank","9133931410"),
            Contact("Rishith","8317579171"),
            Contact("Yuvaraj","8978987389")
        )

        adapter= ContactAdapter(this, contacts)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
    }
}