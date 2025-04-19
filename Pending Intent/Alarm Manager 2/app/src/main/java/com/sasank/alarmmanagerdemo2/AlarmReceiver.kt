package com.sasank.alarmmanagerdemo2

import android.Manifest
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class AlarmReceiver :BroadcastReceiver() {
    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun onReceive(context: Context?, intent: Intent?) {
        val intent= Intent(context, DestinationActivity::class.java)
        intent!!.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent= PendingIntent.getActivity(context,0,intent, PendingIntent.FLAG_IMMUTABLE)

        val builder= NotificationCompat.Builder(context!!,"foxandroid")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Hey, it's time")
            .setContentText("Time ayindhi legu")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val NotificationManager= NotificationManagerCompat.from(context)
        NotificationManager.notify(123,builder.build())
    }

}
