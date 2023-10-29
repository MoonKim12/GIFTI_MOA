package com.example.giftimoa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2
import com.example.giftimoa.adpater_list.HomeFragment_adpater_list

class Search_gift_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_search_gift) // 사용할 레이아웃 파일

        //툴바
        val toolbar: Toolbar = findViewById(R.id.my_toolbar) 
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.title = "GIFTIMOA"

        // ViewPager2와 어댑터 초기화
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        val adapter = HomeFragment_adpater_list(this)
        viewPager.adapter = adapter

        // TabLayout 초기화
        val tabLayout: TabLayout = findViewById(R.id.tabs)

        // TabLayout과 ViewPager2를 연결하여 탭과 페이지 간의 연동을 설정
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // 각 탭의 이름을 설정
            tab.text = when (position) {
                0 -> "커피"
                1 -> "치킨"
                2 -> "피자"
                3 -> "패스트푸드"
                4 -> "편의점･마트"
                5 -> "베이커리"
                6 -> "아이스크림"
                7 -> "외식･분식"
                8 -> "영화"
                else -> "상품권"
            }
        }.attach()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

