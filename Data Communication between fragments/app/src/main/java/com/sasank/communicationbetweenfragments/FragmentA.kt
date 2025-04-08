package com.sasank.communicationbetweenfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FragmentA : Fragment() {
    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_a, container, false)
        communicator=activity as Communicator
        val messageInput=view.findViewById<EditText>(R.id.messageInput)
        val sendButton=view.findViewById<Button>(R.id.sendBtn)
        sendButton.setOnClickListener{
            communicator.passDataCom(messageInput.text.toString())
        }
        return view
    }
}