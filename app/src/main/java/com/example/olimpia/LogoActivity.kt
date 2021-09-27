package com.example.olimpia

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LogoActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);






    }


}

