package com.example.myapplication

import android.content.Intent
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


class B2FLSixth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_b2_flsixth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val backButton = findViewById<ImageButton>(R.id.backButton)
        val option1Button = findViewById<Button>(R.id.option1Button)
        val option2Button = findViewById<Button>(R.id.option2Button)
        val option3Button = findViewById<Button>(R.id.option3Button)
        //Правильный ответ
        option3Button.setOnClickListener {

            option3Button.setBackgroundColor(Color.parseColor("#3366FF"))
            option3Button.setTextColor(Color.WHITE)

            // Переход на следующий экран (замените MainActivity3 на ваш следующий экран)
            val intent = Intent(this, B2FLSeventh::class.java)
            startActivity(intent)
        }

        option2Button.setOnClickListener {
            option2Button.setBackgroundColor(Color.parseColor("#CC1E1E"))
            option2Button.setTextColor(Color.WHITE)
        }

        option1Button.setOnClickListener {

            option1Button.setBackgroundColor(Color.parseColor("#CC1E1E"))
            option1Button.setTextColor(Color.WHITE)
        }

        backButton.setOnClickListener {
            finish() // Закрываем текущую активность
        }
    }
}
