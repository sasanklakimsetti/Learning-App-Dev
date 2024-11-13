package com.sasank.contextmenu

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Sample data for the ListView
        val items= listOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")
        val listView=findViewById<ListView>(R.id.myListView)

        // set up the ListView with an adapter
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,items)
        listView.adapter=adapter

        // register the ListView for the context menu
        registerForContextMenu(listView)

        // setup item click listener for regular clicks
        listView.setOnItemClickListener{_,_,position,_ ->
            val selectedItem=items[position]
            Toast.makeText(this,"Clicked: $selectedItem",Toast.LENGTH_SHORT).show()
        }
    }

    // inflate the context menu when long-pressing an item
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // inflate the context menu layout from XML
        menuInflater.inflate(R.menu.menu,menu)
        menu?.setHeaderTitle("Select an action")
    }

    // handle selection of context menu items
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_edit->{
                var camera=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(camera)
                true
            }
            R.id.action_delete->{
                Toast.makeText(this,"Delete option is selected",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_view -> {
                var camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(camera)
                true
            }
            else-> super.onContextItemSelected(item)
        }
    }

}