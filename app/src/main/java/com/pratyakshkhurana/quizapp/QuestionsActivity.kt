package com.pratyakshkhurana.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions2.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mSelectOptionPosition: Int = 0
    private var mCurrentQuestionIndex: Int = 1
    private lateinit var mQuestionList: ArrayList<Questions>
    private lateinit var mUsername: String
    private var mCorrectAnswers: Int = 0


    private lateinit var mImage: ImageView
    private lateinit var mQuestion: TextView
    private lateinit var mProgressbar: ProgressBar
    private lateinit var mRating: TextView
    private lateinit var mOption1: TextView
    private lateinit var mOption2: TextView
    private lateinit var mOption3: TextView
    private lateinit var mOption4: TextView
    private lateinit var mSubmitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions2)

        mImage = image_flag
        mQuestion = tvQuestion
        mProgressbar = progressBar
        mRating = rating
        mOption1 = option1
        mOption2 = option2
        mOption3 = option3
        mOption4 = option4
        mSubmitButton = submitButton

        mUsername = intent.getStringExtra("user").toString()
        mQuestionList = GetAllQuestions().fetchData()

        setQuestion()

        mOption1.setOnClickListener(this)
        mOption2.setOnClickListener(this)
        mOption3.setOnClickListener(this)
        mOption4.setOnClickListener(this)
        mSubmitButton.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        resetToDefaultOptions()

        val currentQuestion = mQuestionList[mCurrentQuestionIndex - 1]

        if (mCurrentQuestionIndex <= mQuestionList.size) {
            mSubmitButton.text = "Submit"
        }

        mImage.setImageResource(currentQuestion.image)
        mProgressbar.progress = mCurrentQuestionIndex
        mRating.text = "${mCurrentQuestionIndex}/${mQuestionList.size}"
        mQuestion.text = currentQuestion.question
        mOption1.text = currentQuestion.option1
        mOption2.text = currentQuestion.option2
        mOption3.text = currentQuestion.option3
        mOption4.text = currentQuestion.option4
    }

    private fun resetToDefaultOptions() {
        val allOptions = arrayListOf<TextView>()
        allOptions.add(mOption1)
        allOptions.add(mOption2)
        allOptions.add(mOption3)
        allOptions.add(mOption4)

        for (option in allOptions) {
            option.setTextColor(Color.parseColor("#0a0a0a"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.question_options_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionPosition: Int) {
        resetToDefaultOptions()
        mSelectOptionPosition = selectedOptionPosition

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_clicked_bg
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {

        if (view == mOption1) {
            selectedOptionView(mOption1, 1)
        } else if (view == mOption2) {
            selectedOptionView(mOption2, 2)
        } else if (view == mOption3) {
            selectedOptionView(mOption3, 3)
        } else if (view == mOption4) {
            selectedOptionView(mOption4, 4)
        } else if (view == mSubmitButton) {

            if (mSelectOptionPosition == 0) {
                mCurrentQuestionIndex++

                if (mCurrentQuestionIndex <= mQuestionList.size) {
                    setQuestion()
                } else {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("correct", mCorrectAnswers)
                    intent.putExtra("user", mUsername)
                    intent.putExtra("total", 10)
                    startActivity(intent)
                    finish()
                }

            } else {
                val quest = mQuestionList[mCurrentQuestionIndex - 1]

                if (quest.correct != mSelectOptionPosition) {
                    selectedOptionView(mSelectOptionPosition, R.drawable.wrong_option_clicked_bg)
                } else {
                    mCorrectAnswers++
                }
                selectedOptionView(quest.correct, R.drawable.correct_option_clicked_bg)

                if (mCurrentQuestionIndex == mQuestionList.size) {
                    mSubmitButton.text = "FINISH"
                } else {
                    mSubmitButton.text = "GO TO NEXT QUESTION"
                }

                mSelectOptionPosition = 0
            }


        }
    }

    private fun selectedOptionView(answer: Int, drawableView: Int) {

        when (answer) {
            1 -> {
                mOption1.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                mOption2.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                mOption3.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                mOption4.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}


