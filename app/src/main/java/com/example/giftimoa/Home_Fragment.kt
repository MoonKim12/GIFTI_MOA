package com.example.giftimoa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.giftimoa.recyclierview_adpater_list.Banner_Adapter
import me.relex.circleindicator.CircleIndicator3

class Home_Fragment : Fragment() {

    private lateinit var mPager: ViewPager2
    private lateinit var pagerAdapter: FragmentStateAdapter
    private val numPage = 4
    private lateinit var mIndicator: CircleIndicator3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home_, container, false)

        // ViewPager2
        mPager = rootView.findViewById(R.id.viewpager)
        // Adapter
        pagerAdapter = Banner_Adapter(requireActivity(), numPage)
        mPager.adapter = pagerAdapter
        // Indicator
        mIndicator = rootView.findViewById(R.id.indicator)
        mIndicator.setViewPager(mPager)
        mIndicator.createIndicators(numPage, 0)
        // ViewPager 설정
        mPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        mPager.setCurrentItem(1000, true) // 시작 지점 (두 번째 인수로 부드러운 스크롤을 사용하려면 true로 설정)
        mPager.offscreenPageLimit = 4 // 최대 이미지 수

        mPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position, false)
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mIndicator.animatePageSelected(position % numPage)
            }
        })

        return rootView
    }
}