package com.anton.dobrogorsky.familybudget.flow.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anton.dobrogorsky.familybudget.R
import com.anton.dobrogorsky.familybudget.flow.records.RecordsFragment
import com.anton.dobrogorsky.familybudget.flow.report.ReportFragment
import com.anton.dobrogorsky.familybudget.flow.settings.SettingsFragment
import com.anton.dobrogorsky.familybudget.util.replaceFragment
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
                    replaceFragment(SettingsFragment.newInstance())
                    true
                }
                R.id.item_records -> {
                    replaceFragment(RecordsFragment.newInstance())
                    true
                }
                R.id.item_report -> {
                    replaceFragment(ReportFragment.newInstance())
                    true
                }
                else -> false
            }
        }
    }

    private fun initial() {
        replaceFragment(ReportFragment.newInstance())
        supportActionBar?.setTitle(R.string.title_fragment_report)
    }
}
