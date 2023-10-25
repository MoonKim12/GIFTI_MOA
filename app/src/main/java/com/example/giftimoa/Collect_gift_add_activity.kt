package com.example.giftimoa

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class Collect_gift_add_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_collect_gift_add) // 해당 액티비티의 레이아웃 XML 파일을 설정해야 합니다
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                val intent = Intent().apply {
                    //원하는 코드 입력
                }
                setResult()//원하는 코드 입력
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
