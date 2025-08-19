package com.sasank.gridview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat

class ContactAdapter(
    private val context: Context,
    private val contacts: List<Contact>
): BaseAdapter() {
    override fun getCount(): Int {
        return contacts.size
    }

    override fun getItem(pos: Int): Any? {
        return contacts[pos]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getView(
        pos: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val viewHolder: ViewHolder
        val row: View
        if(convertView==null){
            row = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false)
            viewHolder= ViewHolder()
            viewHolder.nameText=row.findViewById<TextView>(R.id.nameText)
            viewHolder.phoneText=row.findViewById<TextView>(R.id.phoneNumber)
            viewHolder.callBtn=row.findViewById<ImageButton>(R.id.callBtnImage)
            row.tag=viewHolder
        }
        else{
            row=convertView
            viewHolder=row.tag as ViewHolder
        }

        val contact=contacts[pos]
        viewHolder.nameText?.text=contact.name
        viewHolder.phoneText?.text=contact.phone
        viewHolder.callBtn?.setOnClickListener {
            val intent= Intent(Intent.ACTION_DIAL)
            intent.data= Uri.parse("tel: ${contact.phone}")
            ContextCompat.startActivity(context,intent,null)
        }
        return row
    }
}

private class ViewHolder{
    var nameText: TextView?=null
    var phoneText: TextView?=null
    var callBtn: ImageButton? =null
}