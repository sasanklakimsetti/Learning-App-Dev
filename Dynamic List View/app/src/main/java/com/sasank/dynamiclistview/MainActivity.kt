package com.sasank.dynamiclistview

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var fruitNameEditText: EditText
    private lateinit var fruitDescriptionEditText: EditText
    private lateinit var fruitImgSelectBtn: Button
    private lateinit var fruitSaveBtn: Button
    private lateinit var fruitDeleteBtn: ImageButton

    private val itemList=mutableListOf<DynamicFruitData>()
    private lateinit var adapter: DynamicListItemAdapter
    private var selectImageUri: Uri? =null
    private val imagePickCode=1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        fruitNameEditText=findViewById(R.id.fruitNameEditText)
        fruitDescriptionEditText=findViewById(R.id.fruitDescriptionEditText)
        fruitImgSelectBtn=findViewById(R.id.fruitImgSelectBtn)
        fruitSaveBtn=findViewById(R.id.fruitSaveBtn)
        fruitDeleteBtn=findViewById(R.id.deleteBtn)
        listView=findViewById(R.id.fruitListView)
        adapter= DynamicListItemAdapter(this, itemList)
        listView.adapter=adapter

        fruitImgSelectBtn.setOnClickListener {
            pickImage()
        }

        fruitSaveBtn.setOnClickListener {
            val title: String = fruitNameEditText.text.toString()
            val subtitle: String = fruitDescriptionEditText.text.toString()
            val imageUri = selectImageUri

            if(title.isNotBlank() && subtitle.isNotBlank() && imageUri!=null){
                itemList.add(DynamicFruitData(imageUri, title, subtitle))
                adapter.notifyDataSetChanged()
                fruitNameEditText.text.clear()
                fruitDescriptionEditText.text.clear()
                selectImageUri=null

                Toast.makeText(this, "Item added: ", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(this, "Every detail and fruit image must be provided", Toast.LENGTH_SHORT).show()
        }
    }

    private fun pickImage() {
        val intent= Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, imagePickCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==imagePickCode && resultCode==RESULT_OK && data!=null){
            selectImageUri=data.data
            Toast.makeText(this, "Image selected", Toast.LENGTH_SHORT).show()
        }
        else Toast.makeText(this, "Error in selecting the image", Toast.LENGTH_SHORT).show()
    }
}