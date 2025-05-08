package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class LessonListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_list)

        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            // Просто закрываем текущую активность, возвращаясь на предыдущую
            finish()
        }
    }
}