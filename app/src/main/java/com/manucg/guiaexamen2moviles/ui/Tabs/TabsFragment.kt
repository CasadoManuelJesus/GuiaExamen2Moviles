package com.manucg.guiaexamen2moviles.ui.Tabs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.manucg.guiaexamen2moviles.R
import com.manucg.guiaexamen2moviles.databinding.FragmentTabsBinding

class TabsFragment : Fragment() {

    private var binding : FragmentTabsBinding ?= null
    private val tabsVM : TabsViewModel by activityViewModels()

    lateinit var tabs : TabLayout
    lateinit var viewPager2 : ViewPager2
    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabsBinding.inflate(inflater, container, false)
        val root : View = binding!!.root

        viewPager2 = binding!!.viewPager2
        viewPagerAdapter = ViewPagerAdapter(this.activity!!)
        viewPager2.adapter = viewPagerAdapter
        tabs = binding!!.tabsLayout

        TabLayoutMediator(tabs!!, viewPager2!!, (
                { tab: TabLayout.Tab?, position: Int ->
                    if (position == 0) tab?.setText("Registrar usuarios")
                    if (position == 1) tab?.setText("Ver usuarios")
                })
        ).attach()

        return root
    }


}