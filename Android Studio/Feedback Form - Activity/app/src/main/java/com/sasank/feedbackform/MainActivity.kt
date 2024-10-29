package com.sasank.feedbackform

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val name:EditText=findViewById(R.id.editTextView1)
        val reg:EditText=findViewById(R.id.editTextView2)
        val a:RadioGroup=findViewById(R.id.radioGrp1)
        val b:RadioGroup=findViewById(R.id.radioGrp2)
        val b1:CheckBox=findViewById(R.id.rgCheck1)
        val b2:CheckBox=findViewById(R.id.rgCheck2)
        val b3:CheckBox=findViewById(R.id.rgCheck3)
        val b4:CheckBox=findViewById(R.id.rgCheck4)
        val spinner:Spinner=findViewById(R.id.spinner)
        val btn:Button=findViewById(R.id.submitBtn)
        val options= arrayOf("LPU","Chandigarh University","Thapar University")
        val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=adapter
        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem= parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        btn.setOnClickListener{
            Toast.makeText(this,"Form submitted successfully",Toast.LENGTH_SHORT)
            val name1=name.text.toString()
            val regNo=reg.text.toString()
            val assignmentDone=when(a.checkedRadioButtonId){
                R.id.rgBtn1->"Yes"
                R.id.rgBtn2->"No"
                else->"Selection must be done"
            }
            val subjects = mutableListOf<String>()
            if (b1.isChecked) subjects.add("CPP")
            if (b2.isChecked) subjects.add("Java")
            if (b3.isChecked) subjects.add("DSA")
            if (b4.isChecked) subjects.add("R")
            val college = spinner.selectedItem.toString()

            val feedback = """
        Name: $name
        Registration No: $regNo
        Assignment Done: $assignmentDone
        Subjects: ${subjects.joinToString(", ")}
        College: $college
    """.trimIndent()

            displayTextView.text = feedback
        }
    }
}