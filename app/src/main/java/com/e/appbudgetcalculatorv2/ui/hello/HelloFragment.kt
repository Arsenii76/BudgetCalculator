package com.e.appbudgetcalculatorv2.ui.hello

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.e.appbudgetcalculatorv2.R
import com.e.appbudgetcalculatorv2.adapters.hello.HelloViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_hello.*

class HelloFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPagerHelloFragment.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        })
        viewPagerHelloFragment.adapter= HelloViewPagerAdapter()
        TabLayoutMediator(tabDotsHelloFragment, viewPagerHelloFragment) { _, _ ->
        }.attach()
    }
}