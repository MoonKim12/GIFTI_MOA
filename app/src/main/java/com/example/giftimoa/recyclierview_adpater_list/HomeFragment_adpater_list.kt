package com.example.giftimoa.recyclierview_adpater_list

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Bakery
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Chicken
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Coffee
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Fastfood
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Giftcard
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Icecream
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Mart
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Movie
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Pizza
import com.example.giftimoa.home_fragment_List.Home_Fragment_List_Snack


class HomeFragment_adpater_list(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 10 // 탭 개수

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Home_Fragment_List_Coffee()
            1 -> Home_Fragment_List_Chicken()
            2 -> Home_Fragment_List_Pizza()
            3 -> Home_Fragment_List_Fastfood()
            4 -> Home_Fragment_List_Mart()
            5 -> Home_Fragment_List_Bakery()
            6 -> Home_Fragment_List_Snack()
            7 -> Home_Fragment_List_Movie()
            8 -> Home_Fragment_List_Icecream()
            else -> Home_Fragment_List_Giftcard() // 기본값 설정
        }
    }
}