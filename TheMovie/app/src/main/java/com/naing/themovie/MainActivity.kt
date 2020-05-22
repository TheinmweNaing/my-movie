package com.naing.themovie

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var toggle: ActionBarDrawerToggle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_closed
        )
        toggle?.syncState()
        toggle?.setToolbarNavigationClickListener {
            Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
        }
        NavigationUI.setupWithNavController(
            navigationView,
            Navigation.findNavController(this, R.id.my_nav_host_fragment)
        )
    }
}
