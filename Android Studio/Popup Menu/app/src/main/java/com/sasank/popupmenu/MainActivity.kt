package com.sasank.popupmenu

import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val buttonShowMenu:Button=findViewById(R.id.btn)
        buttonShowMenu.setOnClickListener{view->
            showPopupMenu(view)
        }
    }
    private fun showPopupMenu(view:View){
        val popup=PopupMenu(this,view)

        val inflater:MenuInflater=popup.menuInflater
        inflater.inflate(R.menu.menu,popup.menu)

        popup.setOnMenuItemClickListener{menuItem:MenuItem->
            when(menuItem.itemId){
                R.id.action_edit->{
                    Toast.makeText(this,"Edit clicked",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_delete-> {
                    Toast.makeText(this, "Delete clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_share->{
                    Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else->{
                    false
                }
            }
        }
        popup.show()
    }
}