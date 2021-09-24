package com.example.olimpia

object Constants {

    fun getQuestions (): ArrayList<Question>{
        val questionsList = ArrayList <Question>()

        // Question 1

        val que1 = Question(
            1,
            "Who is the Celebrity in the picture?",
             R.drawable.ic_olimpia,
            "Kim Kardashian",
            "Hannah Montana",
            "Brittney Spears",
            "Beyonce",
            correctAnswer = 1
        )

        questionsList.add(que1)

        // Question 2

        val que2 = Question(
            2,
            "Who is the Celebrity in the picture?",
            R.drawable.ic_olimpia,
            "Kim Kardashian",
            "Hannah Montana",
            "Brittney Spears",
            "Beyonce",
            correctAnswer = 1
        )

        questionsList.add(que2)

        // Question 3
        val que3 = Question(
            3,
            "Who is the Celebrity in the picture?",
            R.drawable.ic_olimpia,
            "Kim Kardashian",
            "Hannah Montana",
            "Brittney Spears",
            "Beyonce",
            correctAnswer = 1
        )

        questionsList.add(que3)

        // Question 4
        val que4 = Question(
            4,
            "Who is the Celebrity in the picture?",
            R.drawable.ic_olimpia,
            "Kim Kardashian",
            "Hannah Montana",
            "Brittney Spears",
            "Beyonce",
            correctAnswer = 1
        )

        questionsList.add(que4)

        // Question 5
        val que5 = Question(
            5,
            "Who is the Celebrity in the picture?",
            R.drawable.ic_olimpia,
            "Kim Kardashian",
            "Hannah Montana",
            "Brittney Spears",
            "Beyonce",
            correctAnswer = 1
        )

        questionsList.add(que5)

        // Question 6
        val que6 = Question(
            6,
            "Who is the Celebrity in the picture?",
            R.drawable.ic_olimpia,
            "Kim Kardashian",
            "Hannah Montana",
            "Brittney Spears",
            "Beyonce",
            correctAnswer = 1
        )

        questionsList.add(que6)

        // Question 7
        val que7 = Question(
            7,
            "Who is the Celebrity in the picture?",
            R.drawable.ic_olimpia,
            "Kim Kardashian",
            "Hannah Montana",
            "Brittney Spears",
            "Beyonce",
            correctAnswer = 1
        )

        questionsList.add(que7)

        // Question 8
        val que8 = Question(
            8,
            "Who is the Celebrity in the picture?",
            R.drawable.ic_olimpia,
            "ashian",
            "annah tana",
            "Brittney Sprs",
            "Bonce",
            correctAnswer = 1
        )

        questionsList.add(que8)


        // Question 9
        val que9 = Question(
            9,
            "Who is the Celebrity in the picture?",
            R.drawable.ic_olimpia,
            "west",
            "baby",
            "super",
            "Beyonc",
            correctAnswer = 1
        )

        questionsList.add(que9)

        // Question 10
        val que10 = Question(
            10,
            "Who is the Celebrity in the picture?",
            R.drawable.ic_olimpia,
            " Kardashian",
            " Montana",
            " Spears",
            "Beyonce",
            correctAnswer = 1
        )

        questionsList.add(que10)


        return questionsList
    }
}