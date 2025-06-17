package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class B2List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_b2_list)
        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, LessonListActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val firstBlock = findViewById<RelativeLayout>(R.id.text_text_p)
        val secondBlock = findViewById<RelativeLayout>(R.id.text_text_i1)
        val thirdBlock = findViewById<RelativeLayout>(R.id.text_text_i2)
        val fourthBlock = findViewById<RelativeLayout>(R.id.text_text_i3)
        val fifthBlock = findViewById<RelativeLayout>(R.id.text_text_i4)

        firstBlock.setOnClickListener {
            val intent = Intent(this, B2GTFirst::class.java)
            startActivity(intent)
        }
        secondBlock.setOnClickListener {
            val intent = Intent(this, B2VocFirst::class.java)
            startActivity(intent)
        }
        thirdBlock.setOnClickListener {
            val intent = Intent(this, B2ReadFirst::class.java)
            startActivity(intent)
        }
        fourthBlock.setOnClickListener {
            val intent = Intent(this, B2FLFirst::class.java)
            startActivity(intent)
        }
        fifthBlock.setOnClickListener {
            val intent = Intent(this, B2WriteFirst::class.java)
            startActivity(intent)
        }
    }
}