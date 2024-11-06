package com.sasank.feedbackform

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val displayTextView:TextView=findViewById(R.id.formView)
        val name=intent.getStringExtra("name")
        val regNo=intent.getStringExtra("reg")
        val assignmentDone=intent.getStringExtra("done")
        val subjects=intent.getStringArrayExtra("sub")
        val college=intent.getStringExtra("clg")
        val feedback = """
            Name: $name
            Registration No: $regNo
            Assignment Done: $assignmentDone
            Subjects: ${subjects?.joinToString(", ")}
            College: $college
        """.trimIndent()
        displayTextView.text = feedback

        val intent2=Intent(this,MainActivity::class.java)
        val backButton:Button=findViewById(R.id.backBtn)
        backButton.setOnClickListener{
            startActivity(intent2)
        }
    }
}