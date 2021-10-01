package com.example.olimpia

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_names.*



class NamesActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<QuestionsName>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_names)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        mQuestionList = ConstantsNames.getQuestions()
        setQuestion()


        option_false.setOnClickListener (this)
        option_true.setOnClickListener(this)
        btn_submit_name.setOnClickListener(this)

    }

    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPosition-1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size) {
            btn_submit_name.text = "Finish"
        } else {
            btn_submit_name.text = "Submit"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max
        tv_question_name.text = question.question
        names_image.setImageResource(question.image)

        option_false.text = question.option_false
        option_true.text = question.option_true

    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, option_false)
        options.add(1, option_true)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option_false -> {
                selectedOptionView(option_false, 1)
            }
            R.id.option_true -> {
                selectedOptionView(option_true, 2)
            }
            R.id.btn_submit_name -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()

                        }
                        else -> {
                            val intent = Intent(this, ResultActivityCountry::class.java)
                            intent.putExtra(ConstantsCountry.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(ConstantsCountry.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)

                        }

                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn_submit_name.text = "FINISH"
                    } else {
                        btn_submit_name.text = "NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                option_false.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                option_true.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

}