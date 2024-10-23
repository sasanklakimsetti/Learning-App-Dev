package com.sasank.opencamera
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button by its ID and set up the listener
        val openCameraBtn: Button = findViewById(R.id.openCameraBtn)
        openCameraBtn.setOnClickListener {
            openCamera()
        }
    }

    // Function to open the camera using an implicit intent
    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } else {
            // Show a toast message if no camera app is found
            Toast.makeText(this, "No camera app found", Toast.LENGTH_SHORT).show()
        }
    }
}
