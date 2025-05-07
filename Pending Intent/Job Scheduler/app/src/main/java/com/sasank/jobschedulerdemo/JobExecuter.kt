package com.sasank.jobschedulerdemo

import android.os.AsyncTask
import com.sasank.jobschedulerdemo.MainActivity.Companion.counter
import java.lang.Void

open class JobExecuter:AsyncTask<Void, Void, String>() {
    override fun doInBackground(vararg params: Void?): kotlin.String? {
        MainActivity.countSeconds()
        return "Performing in Background $counter time"
    }
}