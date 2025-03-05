package com.sasank.progressbar

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val progressBar=findViewById<ProgressBar>(R.id.progressBar)
        progressBar.max=1000   // default maximum of progressbar is 100
        val currentProgress=600
        ObjectAnimator.ofInt(progressBar,"Progress", currentProgress) // ObjectAnimator will move the progress bar smoothly
            .setDuration(2000)  // the progress will go from 0 to 600 in 2sec
            .start()
    }
}