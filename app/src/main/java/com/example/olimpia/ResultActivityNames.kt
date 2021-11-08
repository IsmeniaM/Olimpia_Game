package com.example.olimpia

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_result_names.*

class ResultActivityNames : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_names)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        val totalQuestions = intent.getIntExtra(ConstantsCountry.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(ConstantsCountry.CORRECT_ANSWERS,0)

        tv_score_names.text = " $correctAnswers out of $totalQuestions"


        btnNames_finish.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }


        registerData()



    }

    fun registerData () {
        btn_register_score_names.setOnClickListener {
            startActivity(Intent(this, DataActivity::class.java))
        }

    }


}