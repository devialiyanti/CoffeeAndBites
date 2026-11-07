package com.example.coffeeandbites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class HomeActivity : AppCompatActivity() {

    private lateinit var rvMenu: RecyclerView
    private lateinit var fabCart: ExtendedFloatingActionButton
    private var userName: String = "Nama"

    private val coffeeList = listOf(
        MenuItem(1, "Affogato", "Espresso shot poured over vanilla ice cream", "Rp 24.000", R.drawable.affogato, "Coffee"),
        MenuItem(2, "Butterscotch Latte", "Espresso, butterscotch syrup, steamed milk", "Rp 26.000", R.drawable.buterschoch_latte, "Coffee"),
        MenuItem(3, "Caramel Latte", "Espresso, caramel syrup, fresh milk", "Rp 25.000", R.drawable.caramel_latte, "Coffee"),
        MenuItem(4, "Hot Americano", "Double shot espresso with hot water", "Rp 20.000", R.drawable.hot_americano, "Coffee"),
        MenuItem(5, "Iced Americano", "Double shot espresso with chilled water and ice", "Rp 20.000", R.drawable.iced_americano, "Coffee"),
        MenuItem(6, "Milk Coffee", "Classic espresso mixed with creamy milk", "Rp 22.000", R.drawable.milk_coffee, "Coffee"),
        MenuItem(7, "Mocha Coffee", "Espresso with rich chocolate syrup and milk", "Rp 26.000", R.drawable.mocha_coffee, "Coffee")
    )

    private val nonCoffeeList = listOf(
        MenuItem(8, "Matcha Latte", "Authentic Japanese matcha with steamed milk", "Rp 27.000", R.drawable.matcha_latte, "Non Coffee"),
        MenuItem(9, "Matcha Ube", "Matcha layer combined with sweet taro ube milk", "Rp 28.000", R.drawable.matcha_ube, "Non Coffee"),
        MenuItem(10, "Milk Chocolate", "Premium cocoa blend with fresh creamy milk", "Rp 24.000", R.drawable.milk_chocolate, "Non Coffee"),
        MenuItem(11, "Strawberry Choco Milk", "Strawberry puree, chocolate syrup, milk", "Rp 26.000", R.drawable.strawberry_choco_milk, "Non Coffee"),
        MenuItem(12, "Thai Tea Milk", "Authentic Thai tea brewed with condensed milk", "Rp 22.000", R.drawable.thai_tea_milk, "Non Coffee")
    )

    private val dessertList = listOf(
        MenuItem(13, "Classic Burger Bun", "Soft toasted burger bun with savory fillings", "Rp 28.000", R.drawable.burger_bun, "Dessert"),
        MenuItem(14, "Choco Berry Cookie", "Soft-baked cookie with dark chocolate and berries", "Rp 18.000", R.drawable.choco_berry, "Dessert"),
        MenuItem(15, "Croissant", "Flaky and buttery golden French croissant", "Rp 22.000", R.drawable.croissant, "Dessert"),
        MenuItem(16, "Sourdough Donuts", "Artisanal sourdough donut with sweet glaze", "Rp 15.000", R.drawable.donuts_sourdough, "Dessert"),
        MenuItem(17, "Dubai Chewy Cookie", "Decadent chewy cookie filled with pistachios & chocolate", "Rp 25.000", R.drawable.dubai_chewy_cookie, "Dessert"),
        MenuItem(18, "French Fries", "Crispy golden seasoned potato fries", "Rp 20.000", R.drawable.french_fries, "Dessert"),
        MenuItem(19, "Ice Cream Brownies", "Warm fudgy brownie topped with vanilla ice cream", "Rp 27.000", R.drawable.ice_cream_rownies, "Dessert"),
        MenuItem(20, "Mix Platter", "Assorted platter of fries, snacks, and finger foods", "Rp 35.000", R.drawable.mix_platter, "Dessert")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        userName = intent.getStringExtra("USER_NAME") ?: "Nama"
        findViewById<TextView>(R.id.tvGreeting).text = "Halo $userName,"

        rvMenu = findViewById(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this)
        fabCart = findViewById(R.id.fabCart)

        val btnCoffee = findViewById<Button>(R.id.btnCatCoffee)
        val btnNonCoffee = findViewById<Button>(R.id.btnCatNonCoffee)
        val btnDessert = findViewById<Button>(R.id.btnCatDessert)
        val btnHeaderProfile = findViewById<ImageButton>(R.id.btnHeaderProfile)

        setCategory(coffeeList, btnCoffee, listOf(btnNonCoffee, btnDessert))

        btnCoffee.setOnClickListener { setCategory(coffeeList, btnCoffee, listOf(btnNonCoffee, btnDessert)) }
        btnNonCoffee.setOnClickListener { setCategory(nonCoffeeList, btnNonCoffee, listOf(btnCoffee, btnDessert)) }
        btnDessert.setOnClickListener { setCategory(dessertList, btnDessert, listOf(btnCoffee, btnNonCoffee)) }

        btnHeaderProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java).apply {
                putExtra("USER_NAME", userName)
            })
        }


        fabCart.setOnClickListener {
            if (CartManager.cartItems.isEmpty()) {
                Toast.makeText(this, "Your cart is empty!", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, ShippingAddressActivity::class.java).apply {
                    putExtra("USER_NAME", userName)
                })
            }
        }

        updateCartBadge()
    }

    override fun onResume() {
        super.onResume()
        updateCartBadge()
    }

    private fun updateCartBadge() {
        val count = CartManager.getTotalItemsCount()
        fabCart.text = "🛒 Cart ($count)"
    }

    private fun setCategory(selectedList: List<MenuItem>, selectedBtn: Button, unselectedBtns: List<Button>) {
        rvMenu.adapter = MenuAdapter(selectedList) {
            updateCartBadge()
        }
        selectedBtn.setBackgroundColor(getColor(R.color.coffee_primary))
        selectedBtn.setTextColor(getColor(R.color.white))

        unselectedBtns.forEach { btn ->
            btn.setBackgroundColor(getColor(R.color.input_border))
            btn.setTextColor(getColor(R.color.text_primary))
        }
    }
}