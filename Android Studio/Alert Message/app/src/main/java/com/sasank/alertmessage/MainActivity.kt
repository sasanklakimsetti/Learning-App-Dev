package com.sasank.alertmessage

import android.os.Bundle
import android.annotation.SuppressLint
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val showDialogButton:Button=findViewById(R.id.alertBtn)
        showDialogButton.setOnClickListener{
            showAlertDialog()
        }
    }
    private fun showAlertDialog(){
        val alertDialog=AlertDialog.Builder(this) // this is going to build the dialog box
            .setTitle("Alert")
            .setMessage("Are you sure, do you want to proceed?")
            .setPositiveButton("OK"){dialog,_->                   // in this, we are using the lambda expression to show the messages when we click on the positive button
                Toast.makeText(this,"You clicked OK",Toast.LENGTH_SHORT).show()
                dialog.dismiss()        // this will dismiss the dialog box i.e. it will disappear after clicking the button in the dialog box
            }
            .setNegativeButton("Cancel"){dialog,_->
                Toast.makeText(this,"You clicked cancel",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .create()
        alertDialog.show()   // this will show the dialog box
    }
}