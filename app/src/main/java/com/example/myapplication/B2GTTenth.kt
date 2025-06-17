package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class B2GTTenth : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_b2_gttenth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val backButton = findViewById<ImageButton>(R.id.backButton)
        val option1Button = findViewById<Button>(R.id.option1Button)
        val option2Button = findViewById<Button>(R.id.option2Button)
        val option3Button = findViewById<Button>(R.id.option3Button)
        // Инициализация SharedPreferences
        sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)

        // Проверка, был ли уже пройден этот уровень
        if (sharedPreferences.getBoolean("B2GTTenth_completed", false)) {
            // Уровень уже пройден, можно показать это визуально
            option2Button.setBackgroundColor(Color.parseColor("#4CAF50")) // Зеленый цвет
            option2Button.setTextColor(Color.WHITE)
        }
        //Правильный ответ
        option2Button.setOnClickListener {

            option2Button.setBackgroundColor(Color.parseColor("#3366FF"))
            option2Button.setTextColor(Color.WHITE)
            // Сохраняем факт прохождения уровня
            sharedPreferences.edit().apply {
                putBoolean("B2GTTenth_completed", true)
                apply() // или commit() для синхронного сохранения
            }
            // Переход на следующий экран (замените MainActivity3 на ваш следующий экран)
            val intent = Intent(this, B2List::class.java)
            startActivity(intent)
        }

        option1Button.setOnClickListener {
            option1Button.setBackgroundColor(Color.parseColor("#CC1E1E"))
            option1Button.setTextColor(Color.WHITE)
        }

        option3Button.setOnClickListener {

            option3Button.setBackgroundColor(Color.parseColor("#CC1E1E"))
            option3Button.setTextColor(Color.WHITE)
        }

        backButton.setOnClickListener {
            finish() // Закрываем текущую активность
        }
    }
}
