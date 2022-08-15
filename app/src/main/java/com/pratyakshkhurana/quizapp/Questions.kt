package com.pratyakshkhurana.quizapp


//model of question, basically a class of data we defined, user defined type
data class Questions(
    val id:Int,
    val question: String,
    val option1:String,
    val option2:String,
    val option3:String,
    val option4:String,
    val correct:Int
    )
