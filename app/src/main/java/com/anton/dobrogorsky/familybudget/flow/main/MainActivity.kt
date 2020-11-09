package com.anton.dobrogorsky.familybudget.flow.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.anton.dobrogorsky.familybudget.R
import com.anton.dobrogorsky.familybudget.flow.records.RecordsFragment
import com.anton.dobrogorsky.familybudget.flow.report.ReportFragment
import com.anton.dobrogorsky.familybudget.flow.settings.SettingsFragment
import com.anton.dobrogorsky.familybudget.flow.util.replaceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initial()

        val mainBottomNavigation = findViewById<BottomNavigationView>(R.id.main_bottom_navigation)
        mainBottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            supportActionBar?.title = menuItem.title
            when (menuItem.itemId) {
                R.id.item_settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    replaceFragment(SettingsFragment())
                }
                R.id.item_records -> {
                    Toast.makeText(this, "Records", Toast.LENGTH_SHORT).show()
                    replaceFragment(RecordsFragment())
                }
                R.id.item_report -> {
                    Toast.makeText(this, "Report", Toast.LENGTH_SHORT).show()
                    replaceFragment(ReportFragment())
                }
            }
            true
        }
    }

    private fun initial() {
        replaceFragment(SettingsFragment())
        supportActionBar?.title = "Settings"
    }
}
