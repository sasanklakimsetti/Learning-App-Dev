package com.sasank.ratingbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
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
        val ratingbar=findViewById<RatingBar>(R.id.ratingbar1)
        val textView=findViewById<TextView>(R.id.tv1)
        val btn=findViewById<Button>(R.id.btn)
        ratingbar.setOnRatingBarChangeListener {rBar, fl, b->
            textView.text=fl.toString()
            when(rBar.rating.toInt()){
                1->textView.text="Very Bad"
                2->textView.text="Bad"
                3->textView.text="Good"
                4->textView.text="Very Good"
                5->textView.text="Excellent"
                else->textView.text="No rating given"
            }
        }
        btn.setOnClickListener {
            val message=ratingbar.rating.toString()
            Toast.makeText(this@MainActivity, "$message rating given",Toast.LENGTH_SHORT).show()
        }
    }
}