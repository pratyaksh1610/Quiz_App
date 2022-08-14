package com.pratyakshkhurana.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "activity_main opened", Toast.LENGTH_SHORT).show()

        buttonStart.setOnClickListener {
            if (enterNameEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name !", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuizCategories::class.java)
                //start intent by passing intent
                //passing data to next activity
                intent.putExtra("user",enterNameEditText.text.toString())
                startActivity(intent)
                //close the current activity from which intent is passed in this case it will
            }
        }
    }
}

