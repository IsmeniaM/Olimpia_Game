package com.example.olimpia

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_countries.*
import kotlinx.android.synthetic.main.activity_logo.*

class LogoActivity : AppCompatActivity() {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<QuestionsLogo>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        mQuestionsList = ConstantsLogo.getQuestions()
        setQuestion()




    }

    private fun setQuestion(){

        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionsList!!.size){
            btn_submit_logo.text = "FINISH"
        }else{
            btn_submit_logo.text = "SUBMIT"
        }

        progressBar_logo.progress = mCurrentPosition
        tv_progress_logo.text = "$mCurrentPosition" + "/"+ progressBar_countries.max

        tv_question_logo.text = question!!.question


    }

    private fun defaultOptionView() {
        val options = ArrayList<ImageView>()
        options.add(0,logo_option_one)
        options.add(1,logo_option_two)
        options.add(2,logo_option_three)
        options.add(3,logo_option_four)

        for (option in options){
            option.background = ContextCompat.getDrawable(this,
                R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)
    }


}

