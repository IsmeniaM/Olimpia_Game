package com.example.olimpia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InstructionsActivityNames : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions_names)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()


        //declare animation
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        val stb = AnimationUtils.loadAnimation(this,R.anim.stb);


        val headertitle = findViewById(R.id.instruction_name) as TextView

        val image_instructions = findViewById(R.id.image_instructions) as ImageView



        // set the animation
        headertitle.startAnimation(ttb)

        image_instructions.startAnimation(stb)




        val startGameNames = findViewById<Button>(R.id.button_play_names)

        startGameNames.setOnClickListener {
            Intent(this, NamesActivity::class.java).also {
                startActivity(it)

            }
        }


    }
}