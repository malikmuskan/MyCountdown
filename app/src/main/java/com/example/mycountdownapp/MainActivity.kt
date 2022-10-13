package com.example.mycountdownapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer



class MainActivity : AppCompatActivity() {


    lateinit var countdown: Chronometer
    var running = false
    var offset: Long = 0
    val offset_key = "offset"
    val running_key = "running"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countdown = findViewById<Chronometer>(R.id.chronometer)
        if(savedInstanceState!= null) {
            offset = savedInstanceState.getLong(offset_key)
            running = savedInstanceState.getBoolean(running_key)


            setTimer(0)
            if (running) {
                countdown.start()
            }
        }
        var one_sec = findViewById<Button>(R.id.one_sec)
        one_sec.setOnClickListener {
            Log.v("button click", " add 1 sec")
            setTimer(1000)

        }
        val five_sec = findViewById<Button>(R.id.five_sec)
        five_sec.setOnClickListener {
            Log.v("button click", "add 5 sec")
            setTimer(5000)
        }
        val ten_sec = findViewById<Button>(R.id.ten_sec)
        ten_sec.setOnClickListener {
            Log.v("button click", "add 10 sec")
            setTimer(100000)


        }
        val start = findViewById<Button>(R.id.start)
        start.setOnClickListener {
            if (!running) {
                setBasetime()
                countdown.start()
                running = true
            }

        }
        val stop = findViewById<Button>(R.id.stop)
        stop.setOnClickListener {
            if (running) {
                saveOffset()
                countdown.stop()
                running = false
            }
        }
        val restart = findViewById<Button>(R.id.stop)
        restart.setOnClickListener {
            offset = 0
            setBasetime()
        }
    }

    private fun setTimer(value:Long) {
        offset +=value
        countdown.base = SystemClock.elapsedRealtime() - offset

    }

    fun saveOffset(){
        var offset = SystemClock.elapsedRealtime() - offset
        TODO("Not yet implemented")
    }

    private fun setBasetime() {
        TODO("Not yet implemented")
        countdown.base = SystemClock.elapsedRealtime() - offset
    }
}

