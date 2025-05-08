package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileCompleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_complete)

        val name = intent.getStringExtra("NAME") ?: "пользователь"
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        welcomeText.text = "Добро пожаловать,\n$name!"

        val continueButton = findViewById<Button>(R.id.continueButton)
        continueButton.setOnClickListener {
            // Создаем Intent для перехода на LessonListActivity
            val intent = Intent(this, LessonListActivity::class.java)
            startActivity(intent)
            finish() // Закрываем текущую активность, если нужно
        }
    }
}