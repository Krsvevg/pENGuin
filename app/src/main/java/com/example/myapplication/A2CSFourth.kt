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
import com.example.myapplication.A2CSFirst

class A2CSFourth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a2_csfourth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val backButton = findViewById<ImageButton>(R.id.backButton)
        val answerInput = findViewById<EditText>(R.id.answerInput)
        val continueButton = findViewById<Button>(R.id.continueButton)
        // Установка фокуса и показ клавиатуры
        answerInput.requestFocus()
        showKeyboard()
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        answerInput.imeOptions = EditorInfo.IME_ACTION_DONE

        answerInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val isCorrectAnswer = s?.toString()?.equals("best", ignoreCase = true) ?: false
                continueButton.isEnabled = isCorrectAnswer
                continueButton.backgroundTintList = ColorStateList.valueOf(
                    if (isCorrectAnswer) Color.parseColor("#3366FF") else Color.parseColor("#F5F5F5")
                )
                continueButton.setTextColor(
                    if (isCorrectAnswer) Color.WHITE else Color.GRAY
                )

                if (isCorrectAnswer) {
                    continueButton.setOnClickListener {
                        // Proceed to next activity
                        val intent = Intent(this@A2CSFourth, A2CSSixth::class.java)
                        startActivity(intent)
                    }
                } else {
                    continueButton.setOnClickListener(null)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
    private fun showKeyboard() {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
        inputMethodManager.toggleSoftInput(android.view.inputmethod.InputMethodManager.SHOW_FORCED, 0)
    }
}