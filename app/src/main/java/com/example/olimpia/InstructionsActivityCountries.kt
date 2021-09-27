package com.example.olimpia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InstructionsActivityCountries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions_countries)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        //declare animation
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        val stb = AnimationUtils.loadAnimation(this,R.anim.stb);

        val headertitle = findViewById(R.id.instructions_country) as TextView

        val image_instructions = findViewById(R.id.idea_image) as ImageView

        // set the animation
        headertitle.startAnimation(ttb)

        image_instructions.startAnimation(stb)



        val startGameCountries = findViewById<Button>(R.id.button_play_countries)

        startGameCountries.setOnClickListener {
            Intent(this, CountriesActivity::class.java).also {
                startActivity(it)

            }
        }
    }

}