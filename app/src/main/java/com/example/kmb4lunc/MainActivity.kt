package com.example.kmb4lunc

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo



class MainActivity : AppCompatActivity() {

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }

    private lateinit var sharedpreferences: SharedPreferences
    private var email: String? = null
    private var password: String? = null

    private val validEmail = "admin@mail.ru"
    private val validPassword = "password123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEdt = findViewById<EditText>(R.id.editTextTextPostalAddress)
        val passwordEdt = findViewById<EditText>(R.id.editTextTextPassword2)
        val loginBtn = findViewById<Button>(R.id.buttonEntrance)

        emailEdt.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                passwordEdt.requestFocus() // Move to the next EditText
                return@setOnEditorActionListener true
            }
            false
        }

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        email = sharedpreferences.getString(EMAIL_KEY, null)
        password = sharedpreferences.getString(PASSWORD_KEY, null)

        loginBtn.setOnClickListener {

            if (TextUtils.isEmpty(emailEdt.text.toString()) || TextUtils.isEmpty(passwordEdt.text.toString())) {
                Toast.makeText(this@MainActivity, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
            } else {
                if (emailEdt.text.toString() == validEmail && passwordEdt.text.toString() == validPassword) {
                    val editor = sharedpreferences.edit()

                    editor.putString(EMAIL_KEY, emailEdt.text.toString())
                    editor.putString(PASSWORD_KEY, passwordEdt.text.toString())

                    editor.apply()

                    val i = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(i)
                    finish()
                } else {
                    val intent = Intent(this@MainActivity, Error1Activity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (email != null && password != null) {
            val i = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(i)
        }
    }
}
