package com.sasank.practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    val requestPermissionsLauncher=registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ){
        permissions->
        val cameraPermissionGranted=permissions[android.Manifest.permission.CAMERA]?:false
        val locationPermissionGranted=permissions[android.Manifest.permission.ACCESS_FINE_LOCATION]?:false
        val accessWIFIGranted=permissions[android.Manifest.permission.ACCESS_WIFI_STATE]?:false
        val changeWIFIGranted=permissions[android.Manifest.permission.CHANGE_WIFI_STATE]?:false
        if (cameraPermissionGranted&&locationPermissionGranted&&accessWIFIGranted&&changeWIFIGranted){
            resultTextView.text="Permissions all accepted including WIFI"
            openAppChooser()
        } else{
            resultTextView.text="Permissions denied"
            Toast.makeText(this,"Permissions denied",Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val requestBtn:Button=findViewById(R.id.requestBtn)
        resultTextView=findViewById(R.id.result)
        requestBtn.setOnClickListener{
            requestPermissions()
        }
    }
    private fun requestPermissions(){
        requestPermissionsLauncher.launch(
            arrayOf(
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_WIFI_STATE,
                android.Manifest.permission.CHANGE_WIFI_STATE
            )
        )
    }
    private fun openAppChooser(){
        val sendIntent=Intent(Intent.ACTION_SEND).apply {
            type="text/plain"
            putExtra(Intent.EXTRA_TEXT,"Hello! Sharing this msg")
        }
        val chooser=Intent.createChooser(sendIntent,"Share using")
        startActivity(chooser)
    }
}