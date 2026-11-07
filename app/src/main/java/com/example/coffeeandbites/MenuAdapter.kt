package com.example.coffeeandbites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class MenuAdapter(
    private val itemList: List<MenuItem>,
    private val onItemAdded: () -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenu: ImageView = itemView.findViewById(R.id.imgMenu)
        val tvName: TextView = itemView.findViewById(R.id.tvMenuName)
        val tvDesc: TextView = itemView.findViewById(R.id.tvMenuDesc)
        val tvPrice: TextView = itemView.findViewById(R.id.tvMenuPrice)
        val btnOrder: Button = itemView.findViewById(R.id.btnOrder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = itemList[position]
        holder.tvName.text = item.name
        holder.tvDesc.text = item.description
        holder.tvPrice.text = item.price
        if (item.imageResId != 0) {
            holder.imgMenu.setImageResource(item.imageResId)
        }

        holder.btnOrder.text = "+ Add"
        holder.btnOrder.setOnClickListener {
            showCustomizeDialog(holder.itemView.context, item)
        }
    }

    override fun getItemCount(): Int = itemList.size

    private fun showCustomizeDialog(context: android.content.Context, item: MenuItem) {
        val dialog = BottomSheetDialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_customize_menu, null)

        val tvTitle = view.findViewById<TextView>(R.id.tvCustomTitle)
        val tvPrice = view.findViewById<TextView>(R.id.tvCustomPrice)
        val tvQty = view.findViewById<TextView>(R.id.tvQtyValue)
        val btnMinus = view.findViewById<Button>(R.id.btnMinusQty)
        val btnPlus = view.findViewById<Button>(R.id.btnPlusQty)

        val layoutDrinkOptions = view.findViewById<LinearLayout>(R.id.layoutDrinkOptions)
        val layoutExtraShot = view.findViewById<LinearLayout>(R.id.layoutExtraShot)

        val rgSize = view.findViewById<RadioGroup>(R.id.rgSize)
        val rgMilk = view.findViewById<RadioGroup>(R.id.rgMilk)
        val rgSugar = view.findViewById<RadioGroup>(R.id.rgSugar)
        val cbExtraShot = view.findViewById<CheckBox>(R.id.cbExtraShot)
        val btnAddToCart = view.findViewById<Button>(R.id.btnConfirmAddToCart)

        tvTitle.text = item.name
        val basePrice = item.price.replace("Rp ", "").replace(".", "").trim().toIntOrNull() ?: 0
        tvPrice.text = item.price

        var currentQty = 1

        btnPlus.setOnClickListener {
            currentQty++
            tvQty.text = currentQty.toString()
        }

        btnMinus.setOnClickListener {
            if (currentQty > 1) {
                currentQty--
                tvQty.text = currentQty.toString()
            }
        }


        when (item.category) {
            "Coffee" -> {
                layoutDrinkOptions.visibility = View.VISIBLE
                layoutExtraShot.visibility = View.VISIBLE
            }
            "Non Coffee" -> {
                layoutDrinkOptions.visibility = View.VISIBLE
                layoutExtraShot.visibility = View.GONE // Tidak ada extra shot
            }
            else -> {
                layoutDrinkOptions.visibility = View.GONE // Hanya order berapa (Qty)
            }
        }

        btnAddToCart.setOnClickListener {
            var additionalPrice = 0
            var sizeText = ""
            var milkText = ""
            var sugarText = ""
            var hasExtraShot = false

            if (item.category == "Coffee" || item.category == "Non Coffee") {
                val selectedSizeId = rgSize.checkedRadioButtonId
                val selectedMilkId = rgMilk.checkedRadioButtonId
                val selectedSugarId = rgSugar.checkedRadioButtonId

                sizeText = view.findViewById<RadioButton>(selectedSizeId)?.text.toString()
                milkText = view.findViewById<RadioButton>(selectedMilkId)?.text.toString()
                sugarText = view.findViewById<RadioButton>(selectedSugarId)?.text.toString()

                if (sizeText.contains("Large")) additionalPrice += 5000
                if (milkText.contains("Oat")) additionalPrice += 5000

                if (item.category == "Coffee" && cbExtraShot.isChecked) {
                    hasExtraShot = true
                    additionalPrice += 6000
                }
            }

            val finalItemPrice = (basePrice + additionalPrice) * currentQty
            val cartItem = CartItem(
                menuItem = item,
                quantity = currentQty,
                size = sizeText,
                milkType = milkText,
                sugarLevel = sugarText,
                extraShot = hasExtraShot,
                itemTotalPrice = finalItemPrice
            )

            CartManager.addItem(cartItem)
            Toast.makeText(context, "${item.name} added to cart!", Toast.LENGTH_SHORT).show()
            onItemAdded()
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }
}