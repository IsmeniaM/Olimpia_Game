package com.example.olimpia

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_names.*


class NamesActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>?=null
    private var mSelectedOptionPosition: Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_names)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        mQuestionList = Constants.getQuestions()
        setQuestion()

        name_option_one.setOnClickListener(this)
        name_option_two.setOnClickListener(this)
        name_option_three.setOnClickListener(this)
        name_option_four.setOnClickListener(this)

    }



    private fun setQuestion() {
        val question = mQuestionList!!.get(mCurrentPosition-1)

        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size)
        {
            btn_submit_name.text = "Finish"
        }
        else
        {
            btn_submit_name.text="Submit"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max
        tv_question_name.text = question.question
        name_option_one.text = question.optionOne
        name_option_two.text = question.optionTwo
        name_option_three.text = question.optionThree
        name_option_four.text = question.optionFour

    }

    override fun onClick (v: View?){
        if (v != null) {
            when(v.id){
                R.id.name_option_one -> {
                    selectedOptionView(name_option_one, 1)
                }
                R.id.name_option_two -> {
                    selectedOptionView(name_option_two, 1)
                }
                R.id.name_option_three -> {
                    selectedOptionView(name_option_three, 1)
                }
                R.id.name_option_four -> {
                    selectedOptionView(name_option_four, 1)
                }
                R.id.btn_submit_name -> {

                    if (mSelectedOptionPosition == 0) {
                        mCurrentPosition++


                        when {
                            mCurrentPosition <= mQuestionList!!.size -> {
                                setQuestion()
                            }
                            else -> {
                                Toast.makeText(
                                    this, "You've sucessfully completed the quiz",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, HomeActivity::class.java)
                                startActivity(intent)
                            }
                        }
                    }else{
                            val question = mQuestionList?.get(mCurrentPosition - 1)
                            if (question!!.correctAnswer != mSelectedOptionPosition) {
                                answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                            }
                            answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                            if (mCurrentPosition == mQuestionList!!.size) {
                                btn_submit_name.text = "Finish"
                            } else {
                                btn_submit_name.text = "Next Question"
                            }
                            mSelectedOptionPosition = 0 }

                }
            }
        }
    }

    private fun defaultOptionsView () {
        val options = ArrayList<TextView>()
        options.add(0, name_option_one)
        options.add(1, name_option_two)
        options.add(2, name_option_three)
        options.add(3, name_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this, R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionView ( tv: TextView,selectedOptionNum:Int){

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)
    }

    private fun answerView(answer: Int, drawableView:Int){

        when (answer){
            1 -> {
                name_option_one.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                name_option_two.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                name_option_three.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                name_option_four.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }




}