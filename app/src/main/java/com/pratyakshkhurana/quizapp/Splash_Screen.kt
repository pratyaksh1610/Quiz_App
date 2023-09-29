package com.pratyakshkhurana.quizapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash_Screen : AppCompatActivity() {
    var sharedPreferences: SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        sharedPreferences=applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        Handler().postDelayed(
            {
                if(sharedPreferences!!.getBoolean("isFirstTimeRun",false))
                {
                    CheckUserName()
                }
                else
                {
                    startActivity(Intent(applicationContext,OnBoardingScreen::class.java))
                    finish()
                }
            },1000
        )

    }
    fun CheckUserName()
    {
        var sharedPreferences=getSharedPreferences("pref", MODE_PRIVATE)
        var name=sharedPreferences.getString("name","")
        if(name!="")
        {
            var intent=Intent(this,QuizCategories::class.java)
            intent.putExtra("user",name)
            startActivity(intent)
        }else{
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }

    }
}