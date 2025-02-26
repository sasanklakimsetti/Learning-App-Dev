package com.sasank.toolbar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            R.id.search->{
                Toast.makeText(this,"Search clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.whatsapp->{
                Toast.makeText(this,"Whatsapp clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.facebook->{
                //Toast.makeText(this,"Facebook clicked",Toast.LENGTH_SHORT).show()
                val fbIntent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))
                startActivity(fbIntent)
                return true
            }
            R.id.instagram->{
                Toast.makeText(this,"Instagram clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.settings->{
                Toast.makeText(this,"Settings clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.about->{
                Toast.makeText(this, "There is nothing to say about us", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.logout->{
                Toast.makeText(this,"Logged out successfully",Toast.LENGTH_SHORT).show()
                return true
            }
            else->super.onOptionsItemSelected(item)
        }
    }
}