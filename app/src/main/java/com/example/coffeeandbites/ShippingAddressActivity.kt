package com.example.coffeeandbites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShippingAddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping_address)

        val name = intent.getStringExtra("USER_NAME") ?: "Name"
        val etName = findViewById<EditText>(R.id.etAddressName)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etAddressDetail = findViewById<EditText>(R.id.etAddressDetail)

        etName.setText(name)

        findViewById<Button>(R.id.btnNextToOrderDetails).setOnClickListener {
            val inputName = etName.text.toString().trim()
            val inputAddress = etAddress.text.toString().trim()
            val inputDetail = etAddressDetail.text.toString().trim()

            if (inputName.isEmpty()) {
                etName.error = "Please fill in your Full Name!"
                etName.requestFocus()
                return@setOnClickListener
            }

            if (inputAddress.isEmpty()) {
                etAddress.error = "Please fill in your Full Address!"
                etAddress.requestFocus()
                return@setOnClickListener
            }

            val intent = Intent(this, OrderValidationActivity::class.java).apply {
                putExtra("USER_NAME", inputName)
                putExtra("USER_ADDRESS", inputAddress)
                putExtra("USER_DETAIL", inputDetail)
            }
            startActivity(intent)
        }
    }
}