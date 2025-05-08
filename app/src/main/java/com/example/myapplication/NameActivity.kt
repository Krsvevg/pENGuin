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

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_name)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton = findViewById<ImageButton>(R.id.backButton)
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val continueButton = findViewById<Button>(R.id.continueButton)

        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        nameInput.imeOptions = EditorInfo.IME_ACTION_DONE

        nameInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val hasInput = !s.isNullOrEmpty()
                continueButton.isEnabled = hasInput
                continueButton.backgroundTintList = ColorStateList.valueOf(
                    if (hasInput) Color.parseColor("#3366FF") else Color.parseColor("#F5F5F5")
                )
                continueButton.setTextColor(
                    if (hasInput) Color.WHITE else Color.parseColor("#888888")
                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        continueButton.setOnClickListener {
            val name = nameInput.text.toString()
            val intent = Intent(this, ProfileCompleteActivity::class.java)
            intent.putExtra("NAME", name)
            startActivity(intent)
        }
    }
}