package com.sasank.listviewtask

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class ContactForm : AppCompatActivity() {
    private lateinit var galleryLauncher: ActivityResultLauncher<Intent>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_form)
        val nameEditText: EditText=findViewById(R.id.name_edittext)
        val mobileEditText: EditText=findViewById(R.id.mobile_edittext)
        val imageUploadBtn: Button=findViewById(R.id.imageAdd_btn)
        val saveBtn: Button=findViewById(R.id.saveBtn)

        saveBtn.setOnClickListener {
            val name=nameEditText.text.toString()
            val mobile=mobileEditText.text.toString()
            val resultIntent= Intent()
            resultIntent.putExtra("name",name)
            resultIntent.putExtra("mobile",mobile)
            setResult(RESULT_OK,resultIntent)
            Toast.makeText(this, "Contact successfully saved", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}