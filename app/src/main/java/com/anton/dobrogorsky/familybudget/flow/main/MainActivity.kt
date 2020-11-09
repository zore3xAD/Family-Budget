package com.anton.dobrogorsky.familybudget.flow.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.anton.dobrogorsky.familybudget.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainBottomNavigation = findViewById<BottomNavigationView>(R.id.main_bottom_navigation)
        mainBottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            supportActionBar?.title = menuItem.title
            when(menuItem.itemId) {
                R.id.item_settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                }
                R.id.item_records -> {
                    Toast.makeText(this, "Records", Toast.LENGTH_SHORT).show()
                }
                R.id.item_report -> {
                    Toast.makeText(this, "Report", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
}