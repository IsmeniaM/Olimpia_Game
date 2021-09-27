package com.example.olimpia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InstructionsActivityNames : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions_names)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()



        val startGameNames = findViewById<Button>(R.id.button_play_names)

        startGameNames.setOnClickListener {
            Intent(this, NamesActivity::class.java).also {
                startActivity(it)

            }
        }
    }
}