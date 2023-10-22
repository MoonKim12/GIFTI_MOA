package com.example.giftimoa.recyclierview_adpater_list

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.giftimoa.Banner_Fragment_1
import com.example.giftimoa.Banner_Fragment_2
import com.example.giftimoa.Banner_Fragment_3
import com.example.giftimoa.Banner_Fragment_4

class Banner_Adapter(private val fa: FragmentActivity, private val count: Int) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        val index = getRealPosition(position)

        return when (index) {
            0 -> Banner_Fragment_1()
            1 -> Banner_Fragment_2()
            2 -> Banner_Fragment_3()
            else -> Banner_Fragment_4()
        }
    }

    override fun getItemCount(): Int {
        return 2000
    }

    private fun getRealPosition(position: Int): Int {
        return position % count
    }
}
