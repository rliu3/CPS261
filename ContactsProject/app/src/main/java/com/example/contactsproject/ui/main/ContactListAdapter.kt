package com.example.contactsproject.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.contactsproject.Contact
import com.example.contactsproject.R

class ContactListAdapter(private val productItemLayout: Int) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    var listener: onItemClickListener? = null

    fun settingListener(listener: onItemClickListener?){
        this.listener = listener
    }

    interface onItemClickListener{
        fun onClick(str: String)
    }


    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        var name = holder.name
        var phone = holder.phone
        var contactId = holder.contactId
        var deleteBtn = holder.deleteBtn

        contactList.let {
            name.text = it!![listPosition].contactName
            phone.text = it!![listPosition].contactPhone
            contactId.text = it!![listPosition].id.toString()

        }
        deleteBtn.setOnClickListener(View.OnClickListener {
            var id = contactId.text.toString()
            listener?.onClick(id)
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            productItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var item: TextView = itemView.findViewById(R.id.product_row)
        var name: TextView = itemView.findViewById(R.id.name)
        var phone: TextView = itemView.findViewById(R.id.phone)
        var contactId: TextView = itemView.findViewById(R.id.contactId)
        var deleteBtn: ImageView = itemView.findViewById(R.id.deleteBtn)
    }
}