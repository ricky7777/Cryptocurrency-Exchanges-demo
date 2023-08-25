package com.nogle.cex

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView


/**
 * @author Ricky Chen
 * Nogle crypto currency exchange entry point
 */
class NogleActivity : AppCompatActivity() {
    private var baselineHeight = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nogle_activity)
        customizeBottomNavigationView(findViewById(R.id.bottom_navigation))
    }

    private fun customizeBottomNavigationView(bottomNavigationView: BottomNavigationView) {
        val menuView = bottomNavigationView.getChildAt(0) as BottomNavigationMenuView

        for (i in 0 until menuView.childCount) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView
            // use customer view
            val customView = LayoutInflater.from(item.context).inflate(R.layout.bottom_nav_item, item, false)
            val textView = customView.findViewById<TextView>(R.id.menuItemText)
            textView.text = bottomNavigationView.menu.getItem(i).title

            // add view
            item.removeAllViews()
            item.addView(customView)
        }
    }



    fun pxToDp(px: Float): Float {
        val density = resources.displayMetrics.density
        return px / density
    }
}