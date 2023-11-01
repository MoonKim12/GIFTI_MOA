package com.example.giftimoa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.giftimoa.bottom_nav_fragment.Collect_fragment
import com.example.giftimoa.databinding.LayoutCollectGiftAddBinding

class Collect_gift_add_activity : AppCompatActivity() {
    private lateinit var binding : LayoutCollectGiftAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutCollectGiftAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.myToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "기프티콘 등록"
    }
    private fun CreateGiftCCollectBtn() {
        binding.AddGiftBtn.setOnClickListener {
            val textgiftiname: String = binding.textGiftName.text.toString()
            val texteffectivedate = binding.textEffectiveDate.text.toString()
            val textbarcode = binding.textBarcode.text.toString()
            val textplace = binding.textPlace.text.toString()

            val intent = Intent(this, Collect_fragment::class.java)
            intent.putExtra("textgiftiname", textgiftiname)
            intent.putExtra("texteffectivedate", texteffectivedate)
            intent.putExtra("textbarcode", textbarcode)
            intent.putExtra("textplace", textplace)
            startActivity(intent)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
