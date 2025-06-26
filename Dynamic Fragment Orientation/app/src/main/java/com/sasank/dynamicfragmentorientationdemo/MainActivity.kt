package com.sasank.dynamicfragmentorientationdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val displayMode=resources.configuration.orientation
        if(displayMode==1) {
            val f1= Fragment1()
            supportFragmentManager.beginTransaction().replace(android.R.id.content, f1).commit()
        }
        else {
            val f2= Fragment2()
            supportFragmentManager.beginTransaction().replace(android.R.id.content, f2).commit()
        }
    }
}