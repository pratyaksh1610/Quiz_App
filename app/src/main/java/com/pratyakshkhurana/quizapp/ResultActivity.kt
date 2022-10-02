package com.pratyakshkhurana.quizapp

import android.annotation.SuppressLint
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        name.text = intent.getStringExtra("user")
        val correct = intent.getIntExtra("correct", 0)
        totalScore.text = "You scored $correct out of 10"

        btnFinish.setOnClickListener {
            val intent = Intent(this, QuizCategories::class.java)
            startActivity(intent)
        }
    }
}