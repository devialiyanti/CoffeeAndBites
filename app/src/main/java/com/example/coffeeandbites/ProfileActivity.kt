package com.example.coffeeandbites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name = intent.getStringExtra("USER_NAME") ?: "Nama"
        findViewById<TextView>(R.id.tvProfileGreeting).text = "Halo $name,"
        val etName = findViewById<EditText>(R.id.etProfileName)
        etName.setText(name)

        findViewById<Button>(R.id.btnSaveProfile).setOnClickListener {
            val updatedName = etName.text.toString()
            startActivity(Intent(this, HomeActivity::class.java).apply {
                putExtra("USER_NAME", updatedName)
            })
            finishAffinity()
        }
    }
}