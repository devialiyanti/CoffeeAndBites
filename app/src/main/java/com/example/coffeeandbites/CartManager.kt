package com.example.coffeeandbites

object CartManager {
    val cartItems = mutableListOf<CartItem>()

    fun addItem(item: CartItem) {
        cartItems.add(item)
    }

    fun clearCart() {
        cartItems.clear()
    }

    fun getTotalItemsCount(): Int {
        var count = 0
        for (item in cartItems) {
            count += item.quantity
        }
        return count
    }

    fun getTotalCartPrice(): Int {
        var total = 0
        for (item in cartItems) {
            total += item.itemTotalPrice
        }
        return total
    }
}