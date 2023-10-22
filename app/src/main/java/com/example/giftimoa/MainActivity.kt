package com.example.giftimoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private val home_Fragment = Home_Fragment()
private val search_Fragment = Search_Fragment()
private val collect_fragment = Collect_fragment()
private val chat_Fragment = Chat_Fragment()
private val menu_Fragment = Menu_Fragment()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnavigationView)

        replaceFragment(home_Fragment)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(home_Fragment)
                R.id.ic_search -> replaceFragment(search_Fragment)
                R.id.ic_collect -> replaceFragment(collect_fragment)
                R.id.ic_chat -> replaceFragment(chat_Fragment)
                R.id.ic_usermenu -> replaceFragment(menu_Fragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.commit()
        }
    }


}