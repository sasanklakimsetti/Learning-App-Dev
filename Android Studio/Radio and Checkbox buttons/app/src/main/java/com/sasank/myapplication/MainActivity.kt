package com.sasank.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
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
        var a=findViewById<RadioGroup>(R.id.rg)
        var b=findViewById<CheckBox>(R.id.checkBox)
        var c=findViewById<CheckBox>(R.id.checkBox2)
        var d=findViewById<CheckBox>(R.id.checkBox3)
        var e=findViewById<Button>(R.id.button)
        e.setOnClickListener{
            var f=a.checkedRadioButtonId
            var g=when(f){
                R.id.radioButton6->"Small"
                R.id.radioButton7->"Medium"
                R.id.radioButton8->"Large"
                else->""
            }
            var h= mutableListOf<String>()
            if(b.isChecked)h.add("Cheese")
            if(c.isChecked)h.add("Corn")
            if (d.isChecked)h.add("Mushroom")
            Toast.makeText(this,g+" Pizza with "+h+" toppings",Toast.LENGTH_SHORT).show()
        }
    }
}