package com.sasank.jobschedulerdemo

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class MyJobService : JobService() {
    private lateinit var jobExecuter: JobExecuter
    override fun onStartJob(params: JobParameters?): Boolean {
        jobExecuter=object : JobExecuter(){
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)

                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT).show()
                }
                jobFinished(params, false)
            }
        }
        jobExecuter.execute()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        if(::jobExecuter.isInitialized) jobExecuter.cancel(true)
        return true
    }
}