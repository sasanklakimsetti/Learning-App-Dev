package com.sasank.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class fruitadapter(
    private val context: Context,
    private val datasource: List<fruititem>
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
        val row=view?:inflater.inflate(R.layout.fruitlist,parent, false)
        val imageView=row.findViewById<ImageView>(R.id.fruitimg)
        val titletxt=row.findViewById<TextView>(R.id.title)
        val subtitleText=row.findViewById<TextView>(R.id.subtitle)
        val item=getItem(pos) as fruititem

        imageView.setImageResource(item.imgsrc)
        titletxt.text=item.title
        subtitleText.text=item.subtitle

        return row
    }
}