package com.latte.catchmymind

import androidx.lifecycle.ViewModel

private const val TAG = "QuizListViewModel"

class QuizListViewModel: ViewModel() {

    val quizList = mutableListOf<Quiz>()

    init{

        for(i in 0 until 10){
            val quiz = Quiz()
            quiz.no = i
            quiz.question = "$i 번 문제"
            quiz.answer = if(i%2 == 0) "정답" else "오답"
            quizList += quiz
        }
    }
}