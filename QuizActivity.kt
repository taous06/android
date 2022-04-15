package com.etdiant.quiz

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList


class QuizActivity: AppCompatActivity() {

    var quizs = ArrayList<Quiz>()
    var numberOfGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        quizs.add(Quiz(question = "Quelle est la capitale d'Algerie ?", answer1 = "Alger", answer2 = "Bejaia", answer3 = "Oran", correctAnswerNumber = 1 ))
        quizs.add(Quiz(question = "Quelle est la capitale de France ?", answer1 = "Lille", answer2 = "Paris", answer3 = "Le Mans", correctAnswerNumber = 2 ))
        quizs.add(Quiz(question = "Quelle est la capitale de l'Angola ?", answer1 = "Tunis", answer2 = "Marrakech", answer3 = "Luanda", correctAnswerNumber = 3 ))
        quizs.add(Quiz(question = "Quelle est la capitale de l'Autriche ?", answer1 = "Yaren", answer2 = "Vienne", answer3 = "Madrid", correctAnswerNumber = 2 ))
        quizs.add(Quiz(question = "Quelle est la capitale de l'Allemagne ?", answer1 = "Berlin", answer2 = "Riad", answer3 = "Kaboul", correctAnswerNumber = 1 ))
        quizs.add(Quiz(question = "Quelle est la capitale de l'Australie ?", answer1 = "Dacca", answer2 = "Bruxelles", answer3 = "Canberra", correctAnswerNumber = 3 ))
        quizs.add(Quiz(question = "Quelle est la capitale du Japon ?", answer1 = "Riga", answer2 = "Tokyo", answer3 = "Maseru", correctAnswerNumber = 2 ))
        quizs.add(Quiz(question = "Quelle est la capitale de l'Afrique du sud ?", answer1 = "Pretoria", answer2 = "Nairobi", answer3 = "Bamako", correctAnswerNumber = 2 ))
        quizs.add(Quiz(question = "Quelle est la capitale de la Norvege ?", answer1 = "Prague", answer2 = "Lima", answer3 = "Oslo", correctAnswerNumber = 3 ))
        quizs.add(Quiz(question = "Quelle est la capitale de l'Arabie Saoudite ?", answer1 = "Riyad", answer2 = "Doha", answer3 = "Dubai", correctAnswerNumber = 1 ))

        // Pour lancer les question aléatoirement
        Collections.shuffle(quizs);
       showQuestion(quizs.get(currentQuizIndex))
    }

    fun showQuestion(quiz: Quiz){

        findViewById<TextView>(R.id.txtQuestion).text = quiz.question
        findViewById<TextView>(R.id.answer1).text = quiz.answer1
        findViewById<TextView>(R.id.answer2).text = quiz.answer2
        findViewById<TextView>(R.id.answer3).text = quiz.answer3

    }
    fun handleAnswer(answerID: Int){
        val quiz = quizs.get(currentQuizIndex)
        if(quiz.isCorrect(answerID)){
            numberOfGoodAnswers++
            Toast.makeText(  this,  "+1", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(  this,  "+0", Toast.LENGTH_SHORT).show()
        }
        //Pour pouvoir aller à la question suivante
        currentQuizIndex++

        if(currentQuizIndex >= quizs.size){// Partie terminé

            val sharedPreferences = getSharedPreferences("com.etdiant.quiz", Context.MODE_PRIVATE)
            sharedPreferences.edit().putInt("userScore", numberOfGoodAnswers).apply()

            var alert = AlertDialog.Builder(this)
            alert.setTitle("Partie Terminée")
            alert.setMessage("Vous avez eu: " + numberOfGoodAnswers + "bonne(s) réponse(s)")
            alert.setPositiveButton( "OK"){ dialogInterface: DialogInterface?, i: Int -> finish()}
            alert.show()
        }else{// On continue la partie
            showQuestion(quizs.get(currentQuizIndex))
        }
    }
    fun onClickAnswerOne(view: View){
        handleAnswer(1)
    }
    fun onClickAnswerTwo(view: View){
        handleAnswer(2)
    }

    fun onClickAnswerThree(view: View){
        handleAnswer(3)
    }
}

