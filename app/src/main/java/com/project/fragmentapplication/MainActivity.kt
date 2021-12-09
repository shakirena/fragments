package com.project.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

lateinit var bottomNavigationMenu: BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)
        val startFragment = StartFragment()
        val endFragment = EndFragment()
        bottomNavigationMenu.selectedItemId = R.id.page_1

        bottomNavigationMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    replaceFragment(endFragment)
                }
                R.id.page_2 -> {
                    replaceFragment(startFragment)
                }

            }
            true
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}