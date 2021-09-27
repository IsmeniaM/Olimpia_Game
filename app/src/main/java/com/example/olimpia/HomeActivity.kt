package com.example.olimpia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        // När man trycker på "Names"

        val NamesButten = findViewById<Button>(R.id.btnNames)

        NamesButten.setOnClickListener {
            Intent(this, InstructionsActivityNames::class.java).also {
                startActivity(it)

            }
        }

        // När man tryker på "Countries"

        val CountriesButten = findViewById<Button>(R.id.btnCountries)

        CountriesButten.setOnClickListener {
            Intent(this,CountriesActivity::class.java).also {
                startActivity(it)

            }
        }

        // När man trycker på "Logo"

        val LogoButten = findViewById<Button>(R.id.btnLogo)

        LogoButten.setOnClickListener {
            Intent(this,LogoActivity::class.java).also {
                startActivity(it)

            }
        }


    }


}