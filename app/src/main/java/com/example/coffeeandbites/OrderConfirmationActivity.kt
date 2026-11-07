package com.example.coffeeandbites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirmation)

        val name = intent.getStringExtra("USER_NAME") ?: "Nama"
        findViewById<TextView>(R.id.tvConfirmGreeting).text = "Halo $name,"

        findViewById<Button>(R.id.btnOke).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("USER_NAME", name)
            }
            startActivity(intent)
            finishAffinity()
        }
    }
}