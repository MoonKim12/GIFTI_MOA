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

class Home_Fragment_List_Coffee : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_home_list_coffee, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_coffee)
        recyclerViewSearchGiftAdapter = RecyclerViewSearchGiftAdapter(requireActivity() as Search_gift_activity, giftList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(requireActivity(), 3)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewSearchGiftAdapter

        // 이 부분에서 데이터를 초기화하도록 수정
        prepareGiftListData()
    }

    private fun prepareGiftListData() {
        var gift = Search_Gift("커피빈", R.drawable.img_brand_coffeebin)
        giftList.add(gift)
        gift = Search_Gift("드롭탑", R.drawable.img_brand_droptop)
        giftList.add(gift)
        gift = Search_Gift("이디야커피", R.drawable.img_brand_ediyacoffee)
        giftList.add(gift)
        gift = Search_Gift("할리스커피", R.drawable.img_brand_hollys)
        giftList.add(gift)
        gift = Search_Gift("잠바쥬스", R.drawable.img_brand_jamba_juice)
        giftList.add(gift)
        gift = Search_Gift("쥬씨", R.drawable.img_brand_juicy)
        giftList.add(gift)
        gift = Search_Gift("메가커피", R.drawable.img_brand_megacoffee)
        giftList.add(gift)
        gift = Search_Gift("팔공티", R.drawable.img_brand_palgongtea)
        giftList.add(gift)
        gift = Search_Gift("파스쿠찌", R.drawable.img_brand_pascucci)
        giftList.add(gift)
        gift = Search_Gift("스타벅스", R.drawable.img_brand_starbucks)
        giftList.add(gift)
        gift = Search_Gift("탐앤탐스", R.drawable.img_brand_tomntoms)
        giftList.add(gift)
        gift = Search_Gift("투썸플레이스", R.drawable.img_brand_twosome_place)
        giftList.add(gift)

        recyclerViewSearchGiftAdapter!!.notifyDataSetChanged()
    }

}
