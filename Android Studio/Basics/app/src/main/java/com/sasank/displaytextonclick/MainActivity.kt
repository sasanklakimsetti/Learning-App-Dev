package com.sasank.displaytextonclick

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sasank.basics1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendNow(view: View) {
        Toast.makeText(this, "Sending Now", Toast.LENGTH_SHORT).show()
    }

    fun receiveNow(view: View) {
        Toast.makeText(this, "Receiving Now", Toast.LENGTH_SHORT).show()
    }

    fun deleteNow(view: View) {
        Toast.makeText(this, "Deleting", Toast.LENGTH_SHORT).show()
    }
}
