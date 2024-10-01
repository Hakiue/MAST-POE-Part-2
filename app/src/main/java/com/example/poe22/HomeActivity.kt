package com.example.poe22

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poe22.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    companion object {
        // Store menu items in a mutable list
        val menuItems = mutableListOf<CulinaryMenuItem>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.totalMenuItemsTextView.text = "Total Menu Items: ${menuItems.size}"

        binding.addMenuItemButton.setOnClickListener {
            val intent = Intent(this, LastSplash::class.java)
            startActivity(intent)
        }

        binding.showMenuButton.setOnClickListener {
            // Navigate to a new screen to display the menu items
            val intent = Intent(this, EndSplash::class.java)
            startActivity(intent)
        }
    }
    // Update the total number of menu items displayed
    private fun updateTotalMenuItems() {
        binding.totalMenuItemsTextView.text = "Total Menu Items: ${CulinaryMenuItem.menuItems.size}"
    }

    // Handle the result from MenuItemEntryActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val itemCount = data?.getIntExtra("itemCount", 0) ?: 0
            binding.totalMenuItemsTextView.text = "Total Menu Items: $itemCount" // Update the text view with new count
        }
    }
}