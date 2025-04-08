package com.sasank.communicationbetweenfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fragmentA= FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragmentA).commit()
    }

    override fun passDataCom(editTextInput: String) {
        val bundle= Bundle()
        bundle.putString("Message", editTextInput)
        val transaction=this.supportFragmentManager.beginTransaction()
        val fragmentB= FragmentB()
        fragmentB.arguments=bundle
        transaction.replace(R.id.fragmentContainer, fragmentB)
        transaction.commit()
    }
}