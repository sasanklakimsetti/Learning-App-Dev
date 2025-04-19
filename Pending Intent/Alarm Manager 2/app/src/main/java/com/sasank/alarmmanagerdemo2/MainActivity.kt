package com.sasank.alarmmanagerdemo2

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.scaleMatrix
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sasank.alarmmanagerdemo2.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat


class MainActivity : AppCompatActivity() {
    internal lateinit var binding: ActivityMainBinding
    internal lateinit var picker: MaterialTimePicker
    internal lateinit var calendar: Calendar
    internal lateinit var alarmManager: AlarmManager
    internal lateinit var pendingIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotificationChannel()
        binding.selectTimeButton.setOnClickListener {
            showTimePicker()
        }
        binding.setAlarmButton.setOnClickListener {
            setAlarm()
        }
        binding.cancelAlarmButton.setOnClickListener {
            cancelAlarm()
        }
    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val name: CharSequence="foxandroidReminderChannel"
            val description="Channel for Alarm Manager"
            val importance= NotificationManager.IMPORTANCE_HIGH
            val channel= NotificationChannel("foxandroid", name, importance)
            channel.description=description
            val notificationManager=getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }
}

private fun MainActivity.cancelAlarm() {
    alarmManager=getSystemService(ALARM_SERVICE) as AlarmManager
    val intent= Intent(this, AlarmReceiver::class.java)
    pendingIntent= PendingIntent.getBroadcast(this,0,intent, PendingIntent.FLAG_IMMUTABLE)
    alarmManager.cancel(pendingIntent)
    Toast.makeText(this,"Alarm Cancelled", Toast.LENGTH_SHORT).show()
}

private fun MainActivity.setAlarm() {
    alarmManager=getSystemService(ALARM_SERVICE) as AlarmManager
    val intent= Intent(this, AlarmReceiver::class.java)
    pendingIntent= PendingIntent.getBroadcast(this,0,intent, PendingIntent.FLAG_IMMUTABLE)
    alarmManager.setRepeating(
        AlarmManager.RTC_WAKEUP,calendar.timeInMillis,
        AlarmManager.INTERVAL_DAY,pendingIntent
    )
    Toast.makeText(this, "Alarm set successfully", Toast.LENGTH_SHORT).show()
}

private fun MainActivity.showTimePicker() {
    picker= MaterialTimePicker.Builder()
        .setTimeFormat(TimeFormat.CLOCK_12H)
        .setHour(12)
        .setMinute(0)
        .setTitleText("Select Alarm Time")
        .build()
    picker.show(supportFragmentManager,"foxandroid")
    picker.addOnPositiveButtonClickListener {
        if(picker.hour>12){
            binding.selectedTime.text=
                String.format("%02d",picker.hour-12)+" : "+String.format("%02d",picker.minute)+"PM"
        } else{
            binding.selectedTime.text=
                String.format("%02d",picker.hour)+" : "+String.format("%02d",picker.minute)+"AM"
        }
        calendar= Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY]=picker.hour
        calendar[Calendar.MINUTE]=picker.minute
        calendar[Calendar.SECOND]=0
        calendar[Calendar.MILLISECOND]=0
    }
}
