package com.example.olimpia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InstructionsActivityCountries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions_countries)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()



        val startGameCountries = findViewById<Button>(R.id.button_play_countries)

        startGameCountries.setOnClickListener {
            Intent(this, CountriesActivity::class.java).also {
                startActivity(it)

            }
        }
    }
}