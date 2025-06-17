package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Имя файла SharedPreferences и ключ для первого запуска
    private val prefsName = "AppPrefs"
    private val firstRunKey = "isFirstRun"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Получаем SharedPreferences
        val prefs: SharedPreferences = getSharedPreferences(prefsName, MODE_PRIVATE)
        val isFirstRun = prefs.getBoolean(firstRunKey, true) // true по умолчанию (первый запуск)

        if (!isFirstRun) {
            // Если не первый запуск, сразу переходим на SecondActivity
            startActivity(Intent(this, LessonListActivity::class.java))
            finish() // Закрываем MainActivity, чтобы нельзя было вернуться
            return // Выходим из метода, чтобы не загружать разметку
        }

        // Если первый запуск — показываем MainActivity
        setContentView(R.layout.activity_main)

        // Анимация логотипа
        val logo = findViewById<ImageView>(R.id.logo)
        logo.alpha = 0f
        logo.animate().alpha(1f).setDuration(1000).start()

        // Обработка кнопки
        val startButton = findViewById<Button>(R.id.big_primary)
        startButton.setOnClickListener {
            // При нажатии кнопки сохраняем, что первый запуск уже был
            prefs.edit().putBoolean(firstRunKey, false).apply()

            // Переходим на SecondActivity
            startActivity(Intent(this, SecondActivity::class.java))
            finish() // Закрываем MainActivity
        }
    }
}