package com.example.olimpia

object Constants {

    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions (): ArrayList<Question>{
        val questionsList = ArrayList <Question>()

        // Question 1

        val que1 = Question(
            1,
            "What is the name of this country?",
             R.drawable.congo,
            "Portugal",
            "Sweden",
            "Congo",
            "Spain",
            correctAnswer = 3
        )

        questionsList.add(que1)

        // Question 2

        val que2 = Question(
            2,
            "What is the name of this country?",
            R.drawable.england,
            "Peru",
            "England",
            "South Africa",
            "Nigeria",
            correctAnswer = 2
        )

        questionsList.add(que2)

        // Question 3
        val que3 = Question(
            3,
            "What is the name of this country?",
            R.drawable.eritrea,
            "Eritrea",
            "India",
            "Sudan",
            "Montenegro",
            correctAnswer = 1
        )

        questionsList.add(que3)

        // Question 4
        val que4 = Question(
            4,
            "What is the name of this country?",
            R.drawable.filand,
            "Sweden",
            "Iceland",
            "England",
            "Finland",
            correctAnswer = 4
        )

        questionsList.add(que4)

        // Question 5
        val que5 = Question(
            5,
            "What is the name of this country?",
            R.drawable.india,
            "India",
            "Marocco",
            "Germany",
            "France",
            correctAnswer = 1
        )

        questionsList.add(que5)

        // Question 6
        val que6 = Question(
            6,
            "What is the name of this country?",
            R.drawable.portugal,
            "Estonia",
            "Spain",
            "Portugal",
            "Latvian",
            correctAnswer = 3
        )

        questionsList.add(que6)

        // Question 7
        val que7 = Question(
            7,
            "What is the name of this country?",
            R.drawable.spain,
            "Spain",
            "Lithuania",
            "Brazil",
            "Norwegian",
            correctAnswer = 1
        )

        questionsList.add(que7)

        // Question 8
        val que8 = Question(
            8,
            "What is the name of this country?",
            R.drawable.sweden,
            "Sweden",
            "Iceland",
            "Moldova",
            "Poland",
            correctAnswer = 1
        )

        questionsList.add(que8)


        // Question 9
        val que9 = Question(
            9,
            "What is the name of this country?",
            R.drawable.america,
            "Hungary",
            "America",
            "Czech Republic",
            "Guinea-Bissau",
            correctAnswer = 2
        )

        questionsList.add(que9)

        // Question 10 (names)
        val que10 = Question(
            10,
            "What is the name of this country?",
            R.drawable.dubai,
            "Dubai",
            "France",
            "Switzerland",
            "Monaco",
            correctAnswer = 1
        )

        questionsList.add(que10)

        return questionsList
    }
}