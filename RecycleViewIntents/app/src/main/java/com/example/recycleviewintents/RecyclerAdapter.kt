package com.example.recycleviewintents
import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.example.recycleviewintents.Data
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
            itemView.setOnClickListener { v: View ->
                val i = Intent(v.getContext(),MainActivity2::class.java)
                var position: Int = getAdapterPosition()
                val title = itemTitle.text
                //val image = R.id.itemImage
                val details = itemDetail.text
                i.putExtra("title",title)
                //i.putExtra("image",image)
                i.putExtra("details",details)

                startActivity(v.context,i,null)

            }
        }

    }
}
