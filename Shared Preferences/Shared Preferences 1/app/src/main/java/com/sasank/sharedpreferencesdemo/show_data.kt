package com.sasank.sharedpreferencesdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sasank.sharedpreferencesdemo.databinding.ActivityMainBinding
import com.sasank.sharedpreferencesdemo.databinding.ActivityShowDataBinding

class show_data : AppCompatActivity() {
    private lateinit var binding: ActivityShowDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val editor=getSharedPreferences("My_Settings",MODE_PRIVATE)
        binding.textView.setText("Your Email is ${editor.getString("email",null)}"
                + "    "+ "and your password is ${editor.getString("password",null)}")
    }
}