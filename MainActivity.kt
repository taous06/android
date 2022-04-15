package com.etdiant.quiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        //on recupere notre score
        val sharedPreferences = getSharedPreferences("com.etdiant.quiz",Context.MODE_PRIVATE)
        val userScore = sharedPreferences.getInt("userScore", -1)

        if(userScore > -1){
            findViewById<TextView>(R.id.textView2).text= "Votre dernier score est de $userScore bonne(s) réponse(s)"
        }
    }
    fun clickBtnPlay(view:View){
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}