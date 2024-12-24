package com.example.kmb4lunc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Error1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_error1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.error)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var againBtn = findViewById<Button>(R.id.button)

        againBtn.setOnClickListener {

            val intent = Intent(this@Error1Activity, MainActivity::class.java)
            startActivity(intent)

        }
    }
}