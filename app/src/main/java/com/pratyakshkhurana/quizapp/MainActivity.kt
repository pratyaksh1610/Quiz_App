package com.pratyakshkhurana.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            if (enterNameEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name !", Toast.LENGTH_SHORT).show()
            } else {
                SaveUserName()
                val intent = Intent(this, QuizCategories::class.java)
                intent.putExtra("user", enterNameEditText.text.toString())
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {
        moveTaskToBack(true);
    }
    fun SaveUserName()
    {
        var sharedPreferences=getSharedPreferences("pref", MODE_PRIVATE)
        var editor=sharedPreferences.edit()
        editor.putString("name",enterNameEditText.text.toString())
        editor.apply()

    }


}

