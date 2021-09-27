package com.example.olimpia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val startButten = findViewById<Button>(R.id.btnStart)

        startButten.setOnClickListener {
            Intent(this, HomeActivity::class.java).also {
                startActivity(it);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        }



    }
}