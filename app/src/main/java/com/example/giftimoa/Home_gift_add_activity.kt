package com.example.giftimoa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.giftimoa.databinding.LayoutCollectGiftAddBinding
import com.example.giftimoa.databinding.LayoutHomeGiftAddBinding

class Home_gift_add_activity : AppCompatActivity() {
    private lateinit var binding : LayoutHomeGiftAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutHomeGiftAddBinding.inflate(layoutInflater)
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