package com.example.poe22

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poe22.databinding.ActivityMenuListBinding

class MenuListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set the adapter with the current menu items from CulinaryMenuItem
        recyclerView.adapter = MenuListAdapter(CulinaryMenuItem.menuItems)
    }
}


