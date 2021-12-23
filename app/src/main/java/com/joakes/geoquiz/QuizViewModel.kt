package com.joakes.geoquiz

import androidx.lifecycle.ViewModel

class QuizViewModel: ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_austrailia, true, false),
        Question(R.string.question_oceans, true, false),
        Question(R.string.question_mideast, false, false),
        Question(R.string.question_africa, false, false),
        Question(R.string.question_americas, true, false),
        Question(R.string.question_asia, true, false)
    )

    var currentIndex = 0

    val currentQuestionAnswer: Boolean
    get() = questionBank[currentIndex].answer

    val currentQuestionTextRes: Int
    get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        currentIndex = if (currentIndex > 0) {
            currentIndex - 1
        } else {
            questionBank.size - 1
        }
    }

    fun cheatedCurrentAnswer(cheated: Boolean? = null): Boolean {
        if (cheated ?: false) { questionBank[currentIndex].cheated = true }
        return questionBank[currentIndex].cheated
    }
}