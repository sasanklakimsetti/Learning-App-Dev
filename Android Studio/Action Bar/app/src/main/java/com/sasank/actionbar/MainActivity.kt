package com.sasank.actionbar

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar:Toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)  // to set the actionbar inside the toolbar
        supportActionBar?.title="Action Bar"
    }
    override fun onCreateOptionsMenu(menu:android.view.Menu?) :Boolean{
        menuInflater.inflate(R.menu.menu_main,menu)  // menuInflater helps to convert the menu from menu file(xml) to kt file
        val settingsItem=menu?.findItem(R.id.action_settings)
        val spannableTitle=SpannableString("Settings")
        spannableTitle.setSpan(ForegroundColorSpan(Color.RED),0,spannableTitle.length,0)  // start tells which position of text the color should apply
        settingsItem?.title=spannableTitle
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_search->{
                //Handle action search
                Toast.makeText(this,"Search selected",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings->{
                // handle action settings
                Toast.makeText(this,"Settings selected",Toast.LENGTH_SHORT).show()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }
}