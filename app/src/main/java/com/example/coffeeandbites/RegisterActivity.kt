package com.example.coffeeandbites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etEmail = findViewById<EditText>(R.id.etEmailReg)
        val etUsername = findViewById<EditText>(R.id.etUsernameReg)
        val etPassword = findViewById<EditText>(R.id.etPasswordReg)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            val name = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()


            when {
                name.isEmpty() -> {
                    etFullName.error = "Please fill in your Full Name!"
                    etFullName.requestFocus()
                }
                email.isEmpty() -> {
                    etEmail.error = "Please fill in your Email!"
                    etEmail.requestFocus()
                }
                username.isEmpty() -> {
                    etUsername.error = "Please fill in your Username!"
                    etUsername.requestFocus()
                }
                password.isEmpty() -> {
                    etPassword.error = "Please fill in your Password!"
                    etPassword.requestFocus()
                }
                else -> {
                    Toast.makeText(this, "Registration Successful! Please Login.", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, LoginActivity::class.java).apply {
                        putExtra("REGISTERED_NAME", name)
                        putExtra("REGISTERED_EMAIL", email)
                        putExtra("REGISTERED_USERNAME", username)
                    }
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}