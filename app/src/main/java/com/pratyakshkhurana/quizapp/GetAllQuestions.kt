package com.pratyakshkhurana.quizapp

class GetAllQuestions {

    fun fetchData(): ArrayList<Questions> {
        val allQuestions = ArrayList<Questions>()
        for (i in 0..9) {
            val eachQuestion = Questions(
                1,
                "Question ${i + 1} ",
                R.drawable.australia,
                "India",
                "Australia",
                "Argentina",
                "Iran",
                2
            )
            allQuestions.add(eachQuestion)
        }
        return allQuestions
    }
}
