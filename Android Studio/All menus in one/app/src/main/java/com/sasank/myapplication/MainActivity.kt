package com.sasank.myapplication

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.text.set
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Action Bar"

        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        val logoutItem = menu?.findItem(R.id.action_logout)
        val spannableTitle = SpannableString("Logout")
        spannableTitle.setSpan(ForegroundColorSpan(Color.RED), 0, spannableTitle.length, 0)
        logoutItem?.title = spannableTitle
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                Toast.makeText(this, "Logout successful", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_share -> {
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showPopupMenu(view: View) {
        val popup = PopupMenu(this, view)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.popup_menu, popup.menu)

        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId){
            R.id.action_call->{
                val phnNum="8317579171"
                val dialIntent=Intent(Intent.ACTION_DIAL)
                dialIntent.data=Uri.parse(phnNum)
                startActivity(dialIntent)
                true
        }
                R.id.action_sms->{
                    val phnNum="8317579171"
                    val smsIntent=Intent(Intent.ACTION_SEND)
                    smsIntent.data=Uri.parse(phnNum)
                    startActivity(smsIntent)
                    true
                }
                else->false
        }
        }
    }
}