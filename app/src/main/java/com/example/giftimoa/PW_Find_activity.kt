package com.example.giftimoa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.giftimoa.databinding.LayoutCollectGiftAddBinding
import com.example.giftimoa.databinding.LayoutSearchIdBinding
import com.example.giftimoa.databinding.LayoutSearchPwBinding

class PW_Find_activity : AppCompatActivity() {
    private lateinit var binding : LayoutSearchPwBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutSearchPwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.myToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}