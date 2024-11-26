package com.sasank.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var b:Button=findViewById(R.id.clickBtn)
        b.setOnClickListener{
            var d=LayoutInflater.from(this).inflate(R.layout.layout,null)
            val b=AlertDialog.Builder(this).setView(d)
            b.setPositiveButton("Subscribe"){dialog,_->
                val e=d.findViewById<EditText>(R.id.editTxt)
                val number=e.text.toString()

                if(number.isNotBlank()) Toast.makeText(this,"Subsribed with $number",Toast.LENGTH_SHORT).show()
                else Toast.makeText(this,"You must enter anything",Toast.LENGTH_SHORT).show()

                dialog.dismiss()
            }
            b.setNegativeButton("Cancel"){dialog,_->
                dialog.dismiss()
            }
            b.create().show()
        }
    }
}