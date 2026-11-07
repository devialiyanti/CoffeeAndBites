package com.example.coffeeandbites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)


        val registeredName = intent.getStringExtra("REGISTERED_NAME") ?: ""
        val registeredUsername = intent.getStringExtra("REGISTERED_USERNAME") ?: ""
        val registeredEmail = intent.getStringExtra("REGISTERED_EMAIL") ?: ""

        if (registeredUsername.isNotEmpty()) etUsername.setText(registeredUsername)
        if (registeredEmail.isNotEmpty()) etEmail.setText(registeredEmail)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()


            when {
                username.isEmpty() -> {
                    etUsername.error = "Please fill in your Username!"
                    etUsername.requestFocus()
                }
                email.isEmpty() -> {
                    etEmail.error = "Please fill in your Email!"
                    etEmail.requestFocus()
                }
                password.isEmpty() -> {
                    etPassword.error = "Please fill in your Password!"
                    etPassword.requestFocus()
                }
                else -> {
                    val finalName = if (registeredName.isNotEmpty()) registeredName else username

                    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java).apply {
                        putExtra("USER_NAME", finalName)
                    }
                    startActivity(intent)
                    finishAffinity()
                }
            }
        }
    }
}