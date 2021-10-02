package com.github.pouyarezaei.basalam_t1.ui.detail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel

class DetailsPagerAdapter(fragment: Fragment, private val data: List<InformationDomainModel>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = data.size

    override fun createFragment(position: Int): Fragment =
        DetailsPagerFragment(data[data.size - position - 1])
}