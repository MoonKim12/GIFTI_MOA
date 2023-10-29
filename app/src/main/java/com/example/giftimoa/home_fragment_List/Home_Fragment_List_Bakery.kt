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

class Home_Fragment_List_Bakery : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_home_list_bakery, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_bakery)
        recyclerViewSearchGiftAdapter = RecyclerViewSearchGiftAdapter(requireActivity() as Search_gift_activity, giftList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(requireActivity(), 3)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewSearchGiftAdapter

        // 이 부분에서 데이터를 초기화하도록 수정
        prepareGiftListData()
    }

    private fun prepareGiftListData() {
        var gift = Search_Gift("던킨도너츠", R.drawable.img_brand_dunkin)
        giftList.add(gift)
        gift = Search_Gift("한스케이크", R.drawable.img_brand_hans)
        giftList.add(gift)
        gift = Search_Gift("홍루이젠", R.drawable.img_brand_hongruizen)
        giftList.add(gift)
        gift = Search_Gift("파리바게트", R.drawable.img_brand_paris_baguette)
        giftList.add(gift)
        gift = Search_Gift("파리크라상", R.drawable.img_brand_paris_crossant)
        giftList.add(gift)
        gift = Search_Gift("뚜레주루", R.drawable.img_brand_tous_res_jour)
        giftList.add(gift)

        recyclerViewSearchGiftAdapter!!.notifyDataSetChanged()

    }

}
