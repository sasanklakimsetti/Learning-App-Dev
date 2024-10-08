package com.sasank.snackbar

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.sasank.snackbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declare the binding variable
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object by inflating the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up a click listener for the button to display a customized Snackbar
        binding.myButton.setOnClickListener {
            val snackbar = Snackbar.make(binding.root, "This is a Snackbar", Snackbar.LENGTH_LONG)

            // Customize the Snackbar background color
            snackbar.view.setBackgroundColor(Color.parseColor("#FF5733"))  // Example: Red background

            // Customize the text color
            snackbar.setTextColor(Color.parseColor("#FFFFFF"))  // White text for the message

            // Customize the action button (UNDO) text and color
            snackbar.setAction("UNDO") {
                // Action to perform on undo
                Snackbar.make(binding.root, "Action undone", Snackbar.LENGTH_SHORT).show()
            }.setActionTextColor(Color.parseColor("#00FF00"))  // Green color for "UNDO" action text

            // Show the customized Snackbar
            snackbar.show()
        }
    }
}