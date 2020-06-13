package com.gunawan.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = resources.getString(R.string.home)
        loadFragment(HomeFragment())

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    title = resources.getString(R.string.home)
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_add -> {
                    title = resources.getString(R.string.add)
                    loadFragment(AddFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_inbox -> {
                    title = resources.getString(R.string.inbox)
                    loadFragment(InboxFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_more -> {
                    title = resources.getString(R.string.more)
                    loadFragment(MoreFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}