package com.sasank.displaytextonclick

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sasank.basics1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Ensure the correct layout file is referenced
    }

    // Method to handle the 'Send now' button click
    fun sendNow(view: View) {
        Toast.makeText(this, "Sending Now", Toast.LENGTH_SHORT).show()
    }

    // Method to handle the 'Receive' button click
    fun receiveNow(view: View) {
        Toast.makeText(this, "Receiving Now", Toast.LENGTH_SHORT).show()
    }

    // Method to handle the 'Delete' button click
    fun deleteNow(view: View) {
        Toast.makeText(this, "Deleting", Toast.LENGTH_SHORT).show()
    }
}
