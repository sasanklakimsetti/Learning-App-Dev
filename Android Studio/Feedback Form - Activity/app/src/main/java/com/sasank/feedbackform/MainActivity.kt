package com.sasank.feedbackform

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var submitted = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name: EditText = findViewById(R.id.editTextView1)
        val reg: EditText = findViewById(R.id.editTextView2)
        val a: RadioGroup = findViewById(R.id.radioGrp1)
        val b1: CheckBox = findViewById(R.id.rgCheck1)
        val b2: CheckBox = findViewById(R.id.rgCheck2)
        val b3: CheckBox = findViewById(R.id.rgCheck3)
        val b4: CheckBox = findViewById(R.id.rgCheck4)
        val spinner: Spinner = findViewById(R.id.spinner)
        val submitBtn: Button = findViewById(R.id.submitBtn)
        val viewBtn: Button = findViewById(R.id.viewBtn) // Assume this is added to activity_main.xml layout

        // Set initial visibility of View button to GONE
        viewBtn.visibility = View.GONE

        val options = arrayOf("LPU", "Chandigarh University", "Thapar University")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        // Clear placeholder text on focus
        name.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) name.setText("")
        }
        reg.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) reg.setText("")
        }
        submitBtn.setOnClickListener {
            if (!submitted) {
                // Validate fields
                if (name.text.isEmpty() || reg.text.isEmpty() || a.checkedRadioButtonId == -1) {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                Toast.makeText(this, "Form submitted successfully", Toast.LENGTH_SHORT).show()
                submitted = true
                viewBtn.visibility = View.VISIBLE // Make "View" button visible after submission

                // Collect data
                val name1 = name.text.toString()
                val regNo = reg.text.toString()
                val assignmentDone = when (a.checkedRadioButtonId) {
                    R.id.rgBtn1 -> "Yes"
                    R.id.rgBtn2 -> "No"
                    else -> "Selection must be done"
                }
                val subjects = mutableListOf<String>()
                if (b1.isChecked) subjects.add("CPP")
                if (b2.isChecked) subjects.add("Java")
                if (b3.isChecked) subjects.add("DSA")
                if (b4.isChecked) subjects.add("R")
                val college = spinner.selectedItem.toString()

                // Set up View button action
                viewBtn.setOnClickListener {
                    val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("name", name1)
                    intent.putExtra("reg", regNo)
                    intent.putExtra("done", assignmentDone)
                    intent.putExtra("sub", subjects.toTypedArray())
                    intent.putExtra("clg", college)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Form already submitted", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
