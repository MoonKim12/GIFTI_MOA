package com.example.giftimoa.bottom_nav_fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.giftimoa.Collect_gift_add_activity
import com.example.giftimoa.Home_gift_add_activity
import com.example.giftimoa.R
import com.example.giftimoa.Search_gift_activity
import com.example.giftimoa.recyclierview_adpater_list.Banner_Adapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
        val commonClickListener = ClickListeners.getCommonClickListener(requireActivity())


        //커피 아이콘 인텐트
        val Home_menu_list_coffee = rootView.findViewById<TextView>(R.id.home_ic_coffee)
        Home_menu_list_coffee.setOnClickListener(commonClickListener)

        //치킨 아이콘 인텐트
        val Home_menu_list_chiken = rootView.findViewById<TextView>(R.id.home_ic_chicken)
        Home_menu_list_chiken.setOnClickListener(commonClickListener)

        //피자 아이콘 인텐트
        val Home_menu_list_pizza = rootView.findViewById<TextView>(R.id.home_ic_pizza)
        Home_menu_list_pizza.setOnClickListener(commonClickListener)

        //패스트푸드 아이콘 인텐트
        val Home_menu_list_fastfood = rootView.findViewById<TextView>(R.id.home_ic_festfood)
        Home_menu_list_fastfood.setOnClickListener(commonClickListener)

        //마트,편의점 아이콘 인텐트
        val Home_menu_list_mart = rootView.findViewById<TextView>(R.id.home_ic_mart)
        Home_menu_list_mart.setOnClickListener(commonClickListener)

        //베이커리 아이콘 인텐트
        val Home_menu_list_bakery = rootView.findViewById<TextView>(R.id.home_ic_bread)
        Home_menu_list_bakery.setOnClickListener(commonClickListener)

        //아이스크림 아이콘 인텐트
        val Home_menu_list_icecream = rootView.findViewById<TextView>(R.id.home_ic_icecream)
        Home_menu_list_icecream.setOnClickListener(commonClickListener)

        //스낵 아이콘 인텐트
        val Home_menu_list_snack = rootView.findViewById<TextView>(R.id.home_ic_snack)
        Home_menu_list_snack.setOnClickListener(commonClickListener)

        //영화 아이콘 인텐트
        val Home_menu_list_movie = rootView.findViewById<TextView>(R.id.home_ic_movie)
        Home_menu_list_movie.setOnClickListener(commonClickListener)

        //상품권 아이콘 인텐트
        val Home_menu_list_giftcard = rootView.findViewById<TextView>(R.id.home_ic_giftcard)
        Home_menu_list_giftcard.setOnClickListener(commonClickListener)

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 플로팅 버튼 클릭 시 다음 화면의 액티비티로 이동
        view.findViewById<FloatingActionButton>(R.id.fab_btn).setOnClickListener {
            val intent = Intent(requireContext(), Home_gift_add_activity::class.java)
            startActivity(intent)
        }
    }

    class ClickListeners {
        companion object {
            //공용 리스너 클래스 정의
            fun getCommonClickListener(activity: Activity): View.OnClickListener {
                return View.OnClickListener {
                    val intent = Intent(activity, Search_gift_activity::class.java)
                    activity.startActivity(intent)
                }
            }
        }
    }
}