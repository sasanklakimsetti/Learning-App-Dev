package com.sasank.listviewtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class contactadapter(
    private val context: Context,
    private val datasource: List<contactitem>
): BaseAdapter() {
    private val inflater: LayoutInflater= LayoutInflater.from(context)
    override fun getCount(): Int {
        return datasource.size
    }

    override fun getItem(pos: Int): Any? {
        return datasource[pos]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getView(
        pos: Int,
        view: View?,
        parent: ViewGroup?
    ): View? {
        val row=view?:inflater.inflate(R.layout.contact_list,parent,false)
        val contactImg=row.findViewById<ImageView>(R.id.contactImg)
        val contactName=row.findViewById<TextView>(R.id.contactName)
        val contactNumber=row.findViewById<TextView>(R.id.contactNumber)
        val item=getItem(pos) as contactitem

        contactImg.setImageResource(item.imgRes)
        contactName.text=item.name
        contactNumber.text=item.mobileNumber.toString()

        return row
    }

}