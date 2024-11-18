package com.sasank.permissionandappchooser

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    val requestPermissionLauncher=registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
        permissions->
        val cameraPermissionGranted=permissions[Manifest.permission.CAMERA]?:false
        val locationPermissionGranted=permissions[Manifest.permission.ACCESS_FINE_LOCATION]?:false
        val wifiStatePermissionGranted=permissions[Manifest.permission.ACCESS_WIFI_STATE]?:false
        val changeWifiStatePermissionGranted=permissions[Manifest.permission.CHANGE_WIFI_STATE]?:false
        if (locationPermissionGranted && cameraPermissionGranted && wifiStatePermissionGranted && changeWifiStatePermissionGranted){
            resultTextView.text="All Permissions Granted including WiFi"
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
        val requestPermissionButton:Button=findViewById(R.id.button)
        resultTextView=findViewById(R.id.text1)
        requestPermissionButton.setOnClickListener{
            requestPermissions()
        }
    }
    private fun requestPermissions(){
        requestPermissionLauncher.launch(
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.CHANGE_WIFI_STATE
            )
        )
    }

    private fun openAppChooser() {
        val sendIntent=Intent(Intent.ACTION_SEND).apply {
            type="text/plain"
            putExtra(Intent.EXTRA_TEXT,"Hello! Sharing this message")
        }
        val chooser=Intent.createChooser(sendIntent,"Share using")
        startActivity(chooser)
    }
}