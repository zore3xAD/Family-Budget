package com.anton.dobrogorsky.familybudget.util

import androidx.fragment.app.Fragment
import com.anton.dobrogorsky.familybudget.R
import com.anton.dobrogorsky.familybudget.flow.main.MainActivity

fun MainActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.main_fragment_container, fragment, fragment.tag)
        .commitAllowingStateLoss()
}