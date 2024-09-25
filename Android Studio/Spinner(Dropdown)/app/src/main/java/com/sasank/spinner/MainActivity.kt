package com.sasank.spinner

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val spinner=findViewById<Spinner>(R.id.spinner)
        val btnShow=findViewById<Button>(R.id.btn)
        // data source for the spinner
        val options= arrayOf("Option 1","Option 2","Option 3","Option 4","Option 5")
        // adapter to connect the data source to Spinner
        val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,options)
        // Specify the layout for dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //set the adapter to the spinner
        spinner.adapter=adapter
        // setup the spinner's item selection listener
        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View?, position:Int, id:Long){
                val selectedItem=parent.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext,"Selected: $selectedItem",Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
// Do something if nothing is selected
            }
        }
        // Button click listener to show selected item in a Toast message
        btnShow.setOnClickListener {
            val selectedOption = spinner.selectedItem.toString()
            Toast.makeText(this, "You selected: $selectedOption", Toast.LENGTH_SHORT).show()
        }

    }
}