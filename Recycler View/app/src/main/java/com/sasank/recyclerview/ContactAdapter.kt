package com.sasank.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(
    private val context: Context,
    private val contactList: List<Contact>
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
    inner class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView=itemView.findViewById(R.id.nameTextView)
        val phone: TextView=itemView.findViewById(R.id.phoneTextView)

        init {
            itemView.setOnClickListener {
                val position=adapterPosition
                val contact=contactList[position]
                Toast.makeText(context, "Clicked: ${contact.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact=contactList[position]
        holder.name.text=contact.name
        holder.phone.text=contact.phone
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}