package com.sasank.listview

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.fruitlist)
        val fruititem=listOf(
            fruititem("Apple","Red",R.drawable.nutrition_24px),
            fruititem("Mango","Yellow",R.drawable.nutrition_24px),
            fruititem("Grapes","Black",R.drawable.nutrition_24px),
            fruititem("Banana","Yellow",R.drawable.nutrition_24px)
        )

        val adapter= fruitadapter(this, fruititem)
        listView.adapter=adapter

        listView.setOnItemClickListener { _, _, pos, _ ->
            val item = fruititem[pos]
            Toast.makeText(this, "Clicked on ${item.title}", Toast.LENGTH_SHORT).show()
        }
    }
}