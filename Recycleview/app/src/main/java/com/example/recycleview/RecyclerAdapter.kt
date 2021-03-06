package com.example.recycleview

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.example.recycleview.Data
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var d = Data()
    private lateinit var arr: ArrayList<ArrayList<Int>>
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        arr = MainViewModel.intlist
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = d.titles[arr[i][0]]
        viewHolder.itemDetail.text = d.details[arr[i][1]]
        viewHolder.itemImage.setImageResource(d.images[arr[i][2]])


    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {

            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

        }
    }
}