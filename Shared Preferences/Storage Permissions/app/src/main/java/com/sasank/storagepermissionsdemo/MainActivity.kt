package com.sasank.storagepermissionsdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sasank.storagepermissionsdemo.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var fileName="myCustomFile.txt"
    val fileError="fileError"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.saveFile.setOnClickListener {
            try {
                val file= File(filesDir, fileName)
                file.writeText(binding.fileContents.text.toString())
                Toast.makeText(this,"File saved", Toast.LENGTH_SHORT).show()
            } catch (e: Exception){
                Toast.makeText(this,"Error file", Toast.LENGTH_SHORT).show()
                Log.d(fileError, "Error: ${e.message}")
            }
        }

        binding.loadFile.setOnClickListener {
            try {
                val file= File(filesDir, fileName)
                binding.tvFileContents.text=file.readText()
            } catch (e: Exception){
                Toast.makeText(this, "Error read file", Toast.LENGTH_SHORT).show()
                Log.d(fileError,"Error: ${e.message}")
            }
        }
    }
}