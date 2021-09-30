package com.example.olimpia

object ConstantsNames {

    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions (): ArrayList<QuestionsName>{
        val questionsList = ArrayList <QuestionsName>()

        // Question 1

        val que1 = QuestionsName(
            1,
            "Is this Celebrity name BEYONCE?",
            R.drawable.beyonce,
            "NO",
            "YES",
            correctAnswer = 2
        )

        questionsList.add(que1)

        // Question 2

        val que2 = QuestionsName(
            2,
            "Is this Celebrity name RIHANNA?",
            R.drawable.adele,
            "NO",
            "YES",
            correctAnswer = 1
        )

        questionsList.add(que2)

        // Question 3
        val que3 = QuestionsName(
            3,
            "Is this Celebrity name NICKI MINAJ?",
            R.drawable.nickiminaj,
            "NO",
            "YES",
            correctAnswer = 2
        )

        questionsList.add(que3)

        // Question 4
        val que4 = QuestionsName(
            4,
            "Is this Celebrity name JAY-Z?",
            R.drawable.kanyewest,
            "NO",
            "YES",
            correctAnswer = 1
        )

        questionsList.add(que4)

        // Question 5
        val que5 = QuestionsName(
            5,
            "Is this Celebrity name MICKAEL JACKSON?",
            R.drawable.mickaeljackson,
            "NO",
            "YES",
            correctAnswer = 2
        )

        questionsList.add(que5)


        return questionsList
    }
}
