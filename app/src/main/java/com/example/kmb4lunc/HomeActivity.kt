package com.example.kmb4lunc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(androidx.appcompat.R.id.home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            v.setBackgroundResource(R.drawable.krugliye_ugli);
            insets
        }
        var textVie = findViewById<TextView>(R.id.textView8)

        textVie.setOnClickListener {
            val intent = Intent(this@HomeActivity, detailedActivity::class.java)
            startActivity(intent)

        }

    }
}

