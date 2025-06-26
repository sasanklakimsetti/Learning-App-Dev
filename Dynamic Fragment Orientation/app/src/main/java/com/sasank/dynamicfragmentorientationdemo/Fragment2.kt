package com.sasank.dynamicfragmentorientationdemo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        val btn: Button=view.findViewById(R.id.redBtn)
        btn.setOnClickListener {
            btn.setBackgroundColor(Color.RED)
        }
        return view
    }
}