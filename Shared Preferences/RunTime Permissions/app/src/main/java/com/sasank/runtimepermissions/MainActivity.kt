package com.sasank.runtimepermissions

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sasank.runtimepermissions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // by using "binding", we don't need to write findViewById again and again. Just use binding.ID
    lateinit var binding: ActivityMainBinding
    lateinit var launchRequest: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)  // binding.root means the layout of the xml i.e. root element
        launchRequest=registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult->
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.R){ // R means version of the android i.e. Android 11
                if(Environment.isExternalStorageManager()) binding.textView.setText("Permission Granted")
                else binding.textView.setText("Permission Not Granted")
            }
        }

        binding.button1.setOnClickListener {
            var intent= Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            intent.addCategory("android.intent.category.DEFAULT")
            intent.setData(Uri.parse(String.format("package:%a", applicationContext.packageName)))
            launchRequest.launch(intent)
        }
    }
}