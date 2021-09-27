package com.example.olimpia

object ConstantsNames {

    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions (): ArrayList<Question>{
        val questionsList = ArrayList <Question>()

        // Question 1

        val que1 = Question(
            1,
            "What is the name of this celebrity?",
            R.drawable.beyonce,
            "Adele MBE",
            "Brittney Spears",
            "Beyonce",
            "Mariah Cary",
            correctAnswer = 3
        )

        questionsList.add(que1)

        // Question 2

        val que2 = Question(
            2,
            "What is the name of this celebrity?",
            R.drawable.adele,
            "Madonna",
            "Adele MBE",
            "Sandra Bullock",
            "Nicki Minaj",
            correctAnswer = 2
        )

        questionsList.add(que2)

        // Question 3
        val que3 = Question(
            3,
            "What is the name of this celebrity?",
            R.drawable.nickiminaj,
            "Nicki Minaj",
            "Angelina Julie",
            "Mariana Rosa",
            "Beyonce",
            correctAnswer = 1
        )

        questionsList.add(que3)

        // Question 4
        val que4 = Question(
            4,
            "What is the name of this celebrity?",
            R.drawable.kanyewest,
            "Justin Bieber",
            "Mickael Jackson",
            "Justin Timberlake",
            "Kanye West",
            correctAnswer = 4
        )

        questionsList.add(que4)

        // Question 5
        val que5 = Question(
            5,
            "What is the name of this celebrity?",
            R.drawable.mickaeljackson,
            "Justin Bieber",
            "Mickael Jackson",
            "Justin Timberlake",
            "Kanye West",
            correctAnswer = 2
        )

        questionsList.add(que5)


        return questionsList
    }
}
