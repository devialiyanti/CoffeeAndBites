package com.example.coffeeandbites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderValidationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_validation)

        val name = intent.getStringExtra("USER_NAME") ?: "Name"
        val address = intent.getStringExtra("USER_ADDRESS") ?: ""
        val detail = intent.getStringExtra("USER_DETAIL") ?: ""

        val tvAddressName = findViewById<TextView>(R.id.tvValAddressName)
        val tvAddressFull = findViewById<TextView>(R.id.tvValAddressFull)
        val tvItemDetails = findViewById<TextView>(R.id.tvValItemDetails)
        val tvTotalPrice = findViewById<TextView>(R.id.tvValTotalPrice)

        tvAddressName.text = "Recipient: $name"
        tvAddressFull.text = if (detail.isNotEmpty()) "Address: $address ($detail)" else "Address: $address"

        val cartItems = CartManager.cartItems
        if (cartItems.isEmpty()) {
            tvItemDetails.text = "No items in cart."
            tvTotalPrice.text = "TOTAL AMOUNT: Rp 0"
        } else {
            val builder = StringBuilder()
            for ((index, item) in cartItems.withIndex()) {
                builder.append("${index + 1}. ${item.menuItem.name} (x${item.quantity})\n")
                if (item.menuItem.category != "Dessert") {
                    val opts = mutableListOf<String>()
                    if (item.size.isNotEmpty()) opts.add(item.size)
                    if (item.milkType.isNotEmpty()) opts.add(item.milkType)
                    if (item.sugarLevel.isNotEmpty()) opts.add(item.sugarLevel)
                    if (item.extraShot) opts.add("Extra Shot")
                    builder.append("   Options: ${opts.joinToString(", ")}\n")
                }
                val formattedSubtotal = String.format("%,d", item.itemTotalPrice).replace(",", ".")
                builder.append("   Subtotal: Rp $formattedSubtotal\n\n")
            }
            tvItemDetails.text = builder.toString().trim()

            val formattedTotal = String.format("%,d", CartManager.getTotalCartPrice()).replace(",", ".")
            tvTotalPrice.text = "TOTAL AMOUNT: Rp $formattedTotal"
        }

        findViewById<Button>(R.id.btnFinalOrderAndSend).setOnClickListener {
            if (CartManager.cartItems.isEmpty()) {
                Toast.makeText(this, "Cart is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, OrderConfirmationActivity::class.java).apply {
                putExtra("USER_NAME", name)
            }
            CartManager.clearCart()
            startActivity(intent)
            finishAffinity()
        }
    }
}