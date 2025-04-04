package com.sasank.datetimepickerdemo

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var DatePickerBtn: Button
    lateinit var textviewDateTime: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        textviewDateTime=findViewById(R.id.textviewDateTime)
        DatePickerBtn=findViewById(R.id.btn)
        DatePickerBtn.setOnClickListener {
            showDateTimePicker()
        }
    }

    private fun showDateTimePicker(){

        // using Calendar class' object to pick the Date
        val calendar= Calendar.getInstance()
        val year=calendar.get(Calendar.YEAR)
        val month= calendar.get(Calendar.MONTH)
        val day=calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            {
                _,selectedYear, selectedMonth, selectedDay->
                val selectedDate="$selectedDay/${selectedMonth+1}/$selectedYear"   // we need to add that +1 to selectedMonth because the Calendar class stores months in 0 indexing
                val hour=calendar.get(Calendar.HOUR_OF_DAY)
                val minute=calendar.get(Calendar.MINUTE)

                TimePickerDialog(this,
                    {
                        _, selectedHour, selectedMin->
                        val selectedTime="$selectedHour:$selectedMin"
                        textviewDateTime.text="Selected Date and Time: $selectedDate $selectedTime"
                    }, hour, minute,false).show()
            },year,month,day).show()
    }
}