package com.example.giftimoa.home_fragment_List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giftimoa.R
import com.example.giftimoa.Search_gift_activity
import com.example.giftimoa.dto.Search_Gift
import com.example.giftimoa.adpater_list.RecyclerViewSearchGiftAdapter

class Home_Fragment_List_Giftcard : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var recyclerViewSearchGiftAdapter: RecyclerViewSearchGiftAdapter? = null
    private var giftList = mutableListOf<Search_Gift>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_list_giftcard, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_giftcard)
        recyclerViewSearchGiftAdapter = RecyclerViewSearchGiftAdapter(requireActivity() as Search_gift_activity, giftList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(requireActivity(), 3)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewSearchGiftAdapter

        // 이 부분에서 데이터를 초기화하도록 수정
        prepareGiftListData()
    }

    private fun prepareGiftListData() {
        var gift = Search_Gift("CJ ONE GIFTCARD", R.drawable.img_brand_cjgiftcard)
        giftList.add(gift)
        gift = Search_Gift("컬쳐랜드", R.drawable.img_brand_cultureland)
        giftList.add(gift)
        gift = Search_Gift("구글 기프트카드", R.drawable.img_brand_google_giftcard)
        giftList.add(gift)
        gift = Search_Gift("해피머니", R.drawable.img_brand_happy_money)
        giftList.add(gift)
        gift = Search_Gift("카카오페이지", R.drawable.img_brand_kakaopage)
        giftList.add(gift)
        gift = Search_Gift("네이버페이", R.drawable.img_brand_naver_pay)
        giftList.add(gift)


        recyclerViewSearchGiftAdapter!!.notifyDataSetChanged()
    }

}
