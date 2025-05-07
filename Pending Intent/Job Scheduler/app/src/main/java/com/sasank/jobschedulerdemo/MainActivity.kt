package com.sasank.jobschedulerdemo

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object{
        var counter: Int=0
        const val JOB_ID: Int=101
        fun countSeconds(){
            counter++
        }
    }
    private lateinit var jobScheduler: JobScheduler
    private lateinit var jobInfo: JobInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val cn= ComponentName(this, MyJobService::class.java)
        val builder=JobInfo.Builder(JOB_ID,cn)
        builder.setPeriodic(15*60*100)  // 15 minutes is the minimum
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
        builder.setPersisted(true)

        jobInfo=builder.build()
        jobScheduler=getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
    }

    fun scheduleJob(v: View){
        jobScheduler.schedule(jobInfo)
        Toast.makeText(this, "Job scheduled", Toast.LENGTH_SHORT).show()
    }

    fun clearJob(v: View){
        jobScheduler.cancel(JOB_ID)
        Toast.makeText(this, "Job cancelled",Toast.LENGTH_SHORT).show()
    }
}