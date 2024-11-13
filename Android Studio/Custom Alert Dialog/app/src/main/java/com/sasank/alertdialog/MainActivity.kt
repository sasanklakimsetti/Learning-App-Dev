package com.sasank.alertdialog

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
        var b=findViewById<Button>(R.id.button)
        b.setOnClickListener{
            var d=LayoutInflater.from(this).inflate(R.layout.layout,null)
            val b=AlertDialog.Builder(this).setView(d)
            b.setPositiveButton("subscribe"){dialog,_->
                val e=d.findViewById<EditText>(R.id.editTextEmailAddress)
                val email=e.text.toString()

                if(email.isNotBlank()) Toast.makeText(this,"Subscribed with $email",Toast.LENGTH_SHORT).show()
                else Toast.makeText(this,"Please enter a valid email address",Toast.LENGTH_SHORT).show()

                dialog.dismiss()
            }
            b.setNegativeButton("Cancel"){dialog,_->
                dialog.dismiss()
            }
            b.create().show()
        }
    }
}