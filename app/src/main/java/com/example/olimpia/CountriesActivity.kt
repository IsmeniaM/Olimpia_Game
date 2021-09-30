package com.example.olimpia

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_countries.*

class CountriesActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        country_option_one.setOnClickListener (this)
        country_option_two.setOnClickListener(this)
        country_option_three.setOnClickListener(this)
        country_option_four.setOnClickListener(this)
        btn_submit_country.setOnClickListener(this)

    }

    private fun setQuestion(){

        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionsList!!.size){
            btn_submit_country.text = "FINISH"
        }else{
            btn_submit_country.text = "SUBMIT"
        }

        progressBar_countries.progress = mCurrentPosition
        tv_progress_countries.text = "$mCurrentPosition" + "/"+ progressBar_countries.max

        tv_question_countries.text = question!!.question
        country_image.setImageResource(question.image)

        country_option_one.text = question.optionOne
        country_option_two.text = question.optionTwo
        country_option_three.text = question.optionThree
        country_option_four.text = question.optionFour

    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0,country_option_one)
        options.add(1,country_option_two)
        options.add(2,country_option_three)
        options.add(3,country_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.country_option_one ->{
                selectedOptionView(country_option_one, 1)
            }
            R.id.country_option_two ->{
                selectedOptionView(country_option_two,2)
            }
            R.id.country_option_three ->{
                selectedOptionView(country_option_three,3)
            }
            R.id.country_option_four ->{
                selectedOptionView(country_option_four,4)
            }
            R.id.btn_submit_country ->{

                if (mSelectedOptionPosition == 0 ){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivityCountry::class.java)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)

                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        btn_submit_country.text = "FINISH"
                    }else{
                        btn_submit_country.text = "NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when (answer){
            1 -> {
                country_option_one.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2 -> {
                country_option_two.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3 -> {
                country_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                country_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }

    }

    private fun selectedOptionView(tv: TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)
    }
}