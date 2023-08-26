package com.nogle.cex

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.nogle.cex.databinding.BottomNavItemBinding
import com.nogle.cex.databinding.NogleActivityBinding


/**
 * @author Ricky Chen
 * Nogle crypto currency exchange entry point
 */
class NogleActivity : AppCompatActivity() {
    private lateinit var binding: NogleActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NogleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setView()
//        setEvent()
    }

    private fun setView() {
        customizeBottomNavigationView()
        val navController = findNavController(R.id.nav_host_fragment)
//        navController.navigate()
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun customizeBottomNavigationView() {
        val bottomNavigationView = binding.bottomNavigation
        val menuView = bottomNavigationView.getChildAt(0) as BottomNavigationMenuView

        for (i in 0 until menuView.childCount) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView
            // use customer view
            val customView = BottomNavItemBinding.inflate(layoutInflater)
            val textView = customView.menuItemText
            textView.text = bottomNavigationView.menu.getItem(i).title

            // add view
            item.removeAllViews()
            item.addView(customView.root)
        }
    }

    private fun setEvent() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.firstFragment -> {
                    Log.i("", "")
                    return@setOnItemSelectedListener true
                }

                R.id.secondFragment -> {
                    Log.i("", "")
                    return@setOnItemSelectedListener true
                }

                R.id.thirdFragment -> {
                    Log.i("", "")
                    return@setOnItemSelectedListener true
                }

                R.id.fourthFragment -> {
                    Log.i("", "")
                    return@setOnItemSelectedListener true
                }

                else -> false
            }
        }
    }
}