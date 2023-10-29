package com.example.giftimoa.recyclierview_adpater_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView // Import CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.giftimoa.R
import com.example.giftimoa.Search_gift_activity
import com.example.giftimoa.dto.Search_Gift

class RecyclerViewSearchGiftAdapter constructor(
    private val getActivity: Search_gift_activity,
    private val giftList: List<Search_Gift>
) : RecyclerView.Adapter<RecyclerViewSearchGiftAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_giftcard, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val gift = giftList[position]
        holder.tv_brand.text = gift.title
        holder.iv_product_preview.setImageResource(gift.image)

        holder.cardView.setOnClickListener {
            Toast.makeText(getActivity, gift.title, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return giftList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_brand: TextView = itemView.findViewById(R.id.tv_brand)
        val iv_product_preview: ImageView = itemView.findViewById(R.id.iv_product_preview)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}
