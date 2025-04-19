package com.sasank.sharedpreferencesdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sasank.sharedpreferencesdemo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val editor=getPreferences(MODE_PRIVATE)
        binding.name.setText(editor.getString("name", null))
        binding.checkbox.isChecked=editor.getBoolean("checked", false)
        binding.saveButton.setOnClickListener {
            val editor=getPreferences(MODE_PRIVATE).edit()
            editor.putString("name",binding.name.text.toString())
            editor.putBoolean("checkbox",binding.checkbox.isChecked)
            editor.commit()
            startActivity(Intent(this,show_data::class.java))
        }
    }
}