package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class LessonListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_list)

        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        // Находим первый блок по ID
        val firstBlock = findViewById<RelativeLayout>(R.id.text_text_p)

        // Добавляем обработчик нажатия
        firstBlock.setOnClickListener {
            // Создаем Intent для перехода на A1List
            val intent = Intent(this, A1List::class.java)
            startActivity(intent)
        }
    }
}