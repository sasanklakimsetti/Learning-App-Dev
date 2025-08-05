package com.sasank.listviewtask

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.contactListView)
        val contactList=listOf(
            contactitem("Sasank","9133931410",R.drawable.account_circle_24px),
            contactitem("Yuvaraj","8978987389",R.drawable.account_circle_24px),
            contactitem("Rishith","8317579171",R.drawable.account_circle_24px),
        )
        val adapter= contactadapter(this, contactList)
        listView.adapter=adapter

        listView.setOnItemClickListener{_,_,pos,_ ->
            val item= contactList[pos]
            Toast.makeText(this,"Clicked on ${item.name}", Toast.LENGTH_SHORT).show()
        }

        val addBtn=findViewById<FloatingActionButton>(R.id.addBtn)
        addBtn.setOnClickListener {
            val intent= Intent(this, ContactForm::class.java)
            startActivity(intent)
        }

    }
}