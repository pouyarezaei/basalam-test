package com.github.pouyarezaei.basalam_t1.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.github.pouyarezaei.basalam_t1.MainActivity
import com.github.pouyarezaei.basalam_t1.R
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel
import com.github.pouyarezaei.basalam_t1.util.findDuplicateChars
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailsFragment : Fragment(R.layout.details_fragment) {
    lateinit var data: List<InformationDomainModel>
    lateinit var viewPager2: ViewPager2
    lateinit var pagerIndicator: TabLayout
    lateinit var detailsTitle: TextView
    lateinit var detailsId: TextView
    lateinit var detailsDuplicateChars: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("UNCHECKED_CAST")
        arguments?.get("data").let {
            data = it as List<InformationDomainModel>
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2 = view.findViewById(R.id.details_pager)
        detailsTitle = view.findViewById(R.id.details_title)
        detailsId = view.findViewById(R.id.details_id)
        pagerIndicator = view.findViewById(R.id.details_pager_indicator)
        detailsDuplicateChars = view.findViewById(R.id.details_duplicates_chars)
        viewPager2.adapter = DetailsPagerAdapter(this, data)

        TabLayoutMediator(pagerIndicator, viewPager2)
        { tab, position -> }.attach()
        detailsTitle.text = getString(
            R.string.recycler_item_title_format,
            data.first().name,
            data.last().name
        )
        detailsDuplicateChars.text = getString(
            R.string.details_duplicate_chars,
            data.first().name?.findDuplicateChars(data.last().name!!)?.joinToString {
                "$it "
            }
        )
        detailsId.text = data.first().id.toString()
        (requireActivity() as MainActivity).toolbarText.text = getString(
            R.string.recycler_item_title_format,
            data.first().name,
            data.last().name
        )
        (requireActivity() as MainActivity).toolbarBackButton.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_mainFragment)
        }

    }
}