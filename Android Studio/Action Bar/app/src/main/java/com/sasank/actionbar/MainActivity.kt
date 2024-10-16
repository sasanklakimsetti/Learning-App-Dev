package com.sasank.actionbar

import android.os.Bundle
import android.view.MenuItem
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
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_search->{
                true
            }
            R.id.action_settings->{
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }
}