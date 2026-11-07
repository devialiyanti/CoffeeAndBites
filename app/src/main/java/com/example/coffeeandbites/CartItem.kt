package com.example.coffeeandbites

data class CartItem(
    val menuItem: MenuItem,
    var quantity: Int,
    val size: String = "",
    val milkType: String = "",
    val sugarLevel: String = "",
    val extraShot: Boolean = false,
    val itemTotalPrice: Int
)