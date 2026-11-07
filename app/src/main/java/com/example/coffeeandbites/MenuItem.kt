package com.example.coffeeandbites

data class MenuItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val imageResId: Int,
    val category: String
)