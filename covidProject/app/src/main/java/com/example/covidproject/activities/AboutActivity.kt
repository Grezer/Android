
package com.example.covidproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covidproject.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}

