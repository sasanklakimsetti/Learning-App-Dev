package com.sasank.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
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
        val toolbar:Toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title="Action Bar"
        var b:Button=findViewById(R.id.btn)
        b.setOnClickListener{view->
            showPopupMenu(view)
        }

        val items= arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul")
        val listView:ListView=findViewById(R.id.listView)
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,items)
        listView.adapter=adapter
        registerForContextMenu(listView)
        listView.setOnItemClickListener{_,_,position,_->
            val selectedItem=items[position]
            Toast.makeText(this,"Selected $selectedItem",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu,menu)
        menu?.setHeaderTitle("Select an option")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_edit->{
                Toast.makeText(this,"Selected Edit",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_share->{
                Toast.makeText(this,"Selected share",Toast.LENGTH_SHORT).show()
                true
            }
            else->super.onContextItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu,menu)
        val logoutItem=menu?.findItem(R.id.action_logout)
        val spannableTitle= SpannableString("Logout")
        spannableTitle.setSpan(ForegroundColorSpan(Color.RED),0,spannableTitle.length,0)
        logoutItem?.title=spannableTitle
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_logout->{
                Toast.makeText(this,"Selected Logout",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_save->{
                Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }
    private fun showPopupMenu(view: View){
        val popup=PopupMenu(this,view)
        val inflater:MenuInflater=popup.menuInflater
        inflater.inflate(R.menu.popup_menu,popup.menu)
        popup.setOnMenuItemClickListener {menuItem:MenuItem->
            when(menuItem.itemId){
                R.id.action_edit->{
                    Toast.makeText(this,"Edit selected",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_delete->{
                    Toast.makeText(this,"Delete selected",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_logout->{
                    Toast.makeText(this,"Logout selected",Toast.LENGTH_SHORT).show()
                    true
                }
                else->false
            }
        }
        popup.show()
    }
}