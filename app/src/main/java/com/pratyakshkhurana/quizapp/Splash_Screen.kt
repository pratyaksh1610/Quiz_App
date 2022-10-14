package com.pratyakshkhurana.quizapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView

class Splash_Screen : AppCompatActivity() {
    var sharedPreferences: SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.lottie_anim)
        lottieAnimationView.playAnimation()
        sharedPreferences=applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        Handler().postDelayed(
            {
                if(sharedPreferences!!.getBoolean("isFirstTimeRun",false))
                {
                    startActivity(Intent(applicationContext,MainActivity::class.java))
                    finish()
                }
                else
                {
                    startActivity(Intent(applicationContext,OnBoardingScreen::class.java))
                    finish()
                }
            },3000)

    }
}