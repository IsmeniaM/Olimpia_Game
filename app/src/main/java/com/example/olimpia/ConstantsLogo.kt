package com.example.olimpia

object ConstantsLogo {


fun getQuestions (): ArrayList<QuestionsLogo>{
    val questionsList = ArrayList <QuestionsLogo>()

    // Question 1

    val que1 = QuestionsLogo(
        1,
        "McDonald ?",
        R.drawable.tap,
        R.drawable.espressohouse,
        R.drawable.mcdonalds,
        R.drawable.apple,
        3

    )

    questionsList.add(que1)

    // Question 2

    val que2 = QuestionsLogo(
        2,
        "Apple?",
        R.drawable.espressohouse ,
        R.drawable.apple,
        R.drawable.axa,
        R.drawable.tap,
        correctAnswer = 2
    )

    questionsList.add(que2)

    // Question 3
    val que3 = QuestionsLogo(
        3,
        "Google?",
        R.drawable.google,
        R.drawable.ica,
        R.drawable.mcdonalds,
        R.drawable.ikea,

        correctAnswer = 1
    )

    questionsList.add(que3)

    // Question 4
    val que4 = QuestionsLogo(
        4,
        "TAP Air Portugal?",
        R.drawable.ikea,
        R.drawable.google,
        R.drawable.espressohouse,
        R.drawable.tap,
        correctAnswer = 4
    )

    questionsList.add(que4)

    // Question 5
    val que5 = QuestionsLogo(
        5,
        "IKEA ?",
        R.drawable.ica,
        R.drawable.ikea,
        R.drawable.google,
        R.drawable.axa,
        correctAnswer = 2
    )

    questionsList.add(que5)


    return questionsList
}
}