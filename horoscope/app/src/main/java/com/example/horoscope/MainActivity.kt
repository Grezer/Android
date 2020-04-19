package com.example.horoscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    lateinit var calendarV: calendarView;
    lateinit var textV: ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendarV.calendarView = R.id.calendarView
        textV.textView = R.id.textView

        calendarV.setOnDateChangeListener {
            textV.text = "asdfasdf"

        }
    }
}
