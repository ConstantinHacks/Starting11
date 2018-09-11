package com.constantinkoehler.starting11

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.constantinkoehler.starting11.Model.Player
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val selectedFragment = LineupFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,selectedFragment).commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val selectedFragment = PlayerListFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,selectedFragment).commit()

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,LineupFragment.newInstance()).commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
