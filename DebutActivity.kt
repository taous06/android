package com.etdiant.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class DebutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debut)

        val entrer = findViewById<Button>(R.id.button3)
        val login = findViewById<EditText>(R.id.editTextTextPersonName)
        val password = findViewById<EditText>(R.id.editTextTextPassword)

        entrer.setOnClickListener {
            val txtLogin = login.text.toString()
            val txtPassword = password.text.toString()
        }
    }



    fun clickBtnEntrer(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
