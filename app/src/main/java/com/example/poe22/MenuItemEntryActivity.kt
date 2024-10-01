package com.example.poe22

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.poe22.databinding.ActivityMenuItemEntryBinding

class MenuItemEntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuItemEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuItemEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup spinner for course selection
        val courses = listOf("Starters", "Mains", "Desserts")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.courseSpinner.adapter = spinnerAdapter

        // Handle Add Menu Item button click
        binding.addButton.setOnClickListener {
            val dishName = binding.dishNameEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()
            val course = binding.courseSpinner.selectedItem.toString()
            val price = binding.priceEditText.text.toString().toDoubleOrNull()

            // Input validation
            if (dishName.isNotEmpty() && description.isNotEmpty() && price != null) {
                // Create a new menu item
                val menuItem = CulinaryMenuItem(dishName, description, course, price)

                // Add menu item to the companion object's list
                CulinaryMenuItem.menuItems.add(menuItem)

                // Display a success message
                Toast.makeText(this, "Menu item added", Toast.LENGTH_SHORT).show()

                // Clear the input fields
                binding.dishNameEditText.text.clear()
                binding.descriptionEditText.text.clear()
                binding.priceEditText.text.clear()
                binding.courseSpinner.setSelection(0) // Reset spinner selection
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle View Menu List button click
        binding.viewMenuItemsButton.setOnClickListener {
            // Start MenuListActivity to show the menu items
            val intent = Intent(this, EndSplash::class.java) // Ensure this is the correct activity
            startActivity(intent)
        }
    }
}


