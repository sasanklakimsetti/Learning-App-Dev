package com.sasank.swipeviewdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                FragmentFirst()
            }
            1->{
                FragmentSecond()
            }
            else->{
                FragmentThird()
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

}