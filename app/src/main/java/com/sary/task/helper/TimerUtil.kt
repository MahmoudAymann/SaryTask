package com.sary.task.helper

import android.os.Handler
import android.os.Looper
import java.util.*

object TimerUtil {

    fun setTimerWithPeriodAndDelay(
        runnableTask: Runnable,
        delayInMillis: Long,
        periodInMillis: Long
    ): Timer {
        val handler = Handler(Looper.getMainLooper())
        val timer = Timer() // creating a new thread
        timer.schedule(object : TimerTask() {
            // task to be scheduled
            override fun run() {
                handler.post(runnableTask)
            }
        }, delayInMillis, periodInMillis)
        return timer
    }

}