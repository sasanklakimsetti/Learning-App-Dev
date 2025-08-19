package com.sasank.dynamiclistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DynamicListItemAdapter(
    private val context: Context,
    private val items: MutableList<DynamicFruitData>
): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(pos: Int): Any? {
        return items[pos]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getView(
        pos: Int,
        convertView: View?,
        parentView: ViewGroup?
    ): View? {
        val view=convertView?: LayoutInflater.from(context).inflate(R.layout.fruitlist, parentView, false)
        val item=items[pos]

        val imageView: ImageView = view.findViewById(R.id.fruitimg)
        val title: TextView=view.findViewById(R.id.title)
        val subtitle: TextView=view.findViewById(R.id.subtitle)

        imageView.setImageURI(item.img)
        title.text=item.name
        subtitle.text=item.description

        return view
    }
}