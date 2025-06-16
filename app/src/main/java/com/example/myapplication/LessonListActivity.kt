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
        val secondBlock = findViewById<RelativeLayout>(R.id.text_text_i1)
        val thirdBlock = findViewById<RelativeLayout>(R.id.text_text_i2)
        val fourthBlock = findViewById<RelativeLayout>(R.id.text_text_i3)
        val fifthBlock = findViewById<RelativeLayout>(R.id.text_text_i4)
        val sixthBlock = findViewById<RelativeLayout>(R.id.text_text_i5)

        // Добавляем обработчик нажатия
        firstBlock.setOnClickListener {
            val intent = Intent(this, A1List::class.java)
            startActivity(intent)
        }
        secondBlock.setOnClickListener {
            val intent = Intent(this, A2List::class.java)
            startActivity(intent)
        }
        thirdBlock.setOnClickListener {
            val intent = Intent(this, B1List::class.java)
            startActivity(intent)
        }
        fourthBlock.setOnClickListener {
            val intent = Intent(this, B2List::class.java)
            startActivity(intent)
        }
        fifthBlock.setOnClickListener {
            val intent = Intent(this, C1List::class.java)
            startActivity(intent)
        }
        sixthBlock.setOnClickListener {
            val intent = Intent(this, C2List::class.java)
            startActivity(intent)
        }
    }
}