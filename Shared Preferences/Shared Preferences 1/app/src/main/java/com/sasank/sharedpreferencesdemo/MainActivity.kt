package com.sasank.sharedpreferencesdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sasank.sharedpreferencesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val editor=getSharedPreferences("My_Settings",MODE_PRIVATE)
        binding.email.setText(editor.getString("email",null))
        binding.password.setText(editor.getString("password",null))
        binding.settingsButton.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        binding.login.setOnClickListener {
            val editor=getSharedPreferences("My_Settings",MODE_PRIVATE).edit()
            editor.putString("email",binding.email.text.toString())
            editor.putString("password",binding.password.text.toString())
            editor.commit()
            startActivity(Intent(this,show_data::class.java))
        }
    }
}