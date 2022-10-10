package com.example.mycountdownapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer



class MainActivity : AppCompatActivity() {


    lateinit var countdown:Chronometer
    var running = false
    var offset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countdown = findViewById<Chronometer>(R.id.countdown)

         var restartbtn = findViewById<Button>(R.id.restartbtn)
        restartbtn.setOnClickListener {
            if(!running) {
                setBasetime()
                countdown.restart()
                offset= 0
                running = true
            }
        }
        var plusbtn = findViewById<Button>(R.id.plusbtn)
        plusbtn.setOnClickListener{
            if(running){
                saveOffset()
                countdown.plus()
                offset = 0
                running=true

            }
        }
        var incbtn = findViewById<Button>(R.id.incbtn)
        incbtn.setOnClickListener{
            if(running)
                countdown.inc()
            running= true
        }



    }



    private fun setBasetime() {
        TODO("Not yet implemented")
        countdown.base = SystemClock.elapsedRealtime() - offset
    }
}

private fun Chronometer.inc() {
    TODO("Not yet implemented")
}


    private fun saveOffset() {
        var offset: Long = SystemClock.elapsedRealtime()
        TODO("Not yet implemented")
    }


    private fun Chronometer.plus() {
    TODO("Not yet implemented")
}

private fun Chronometer.restart() {
    TODO("Not yet implemented")
}
