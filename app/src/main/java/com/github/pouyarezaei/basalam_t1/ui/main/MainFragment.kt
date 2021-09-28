package com.github.pouyarezaei.basalam_t1.ui.main

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.pouyarezaei.basalam_t1.R
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel
import com.github.pouyarezaei.basalam_t1.util.setFont

class MainFragment : Fragment(R.layout.main_fragment),
    MainRecyclerAdapter.RecyclerViewItemClick<List<InformationDomainModel>> {
    companion object {
        const val BUNDLE_KEY = "data"
    }

    private val viewModel: MainViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var text: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.main_recycler_view)
        recyclerView.adapter = MainRecyclerAdapter(mutableListOf(), this)
    }

    override fun click(model: List<InformationDomainModel>) {
        val bundle = Bundle()
        bundle.putParcelableArrayList(BUNDLE_KEY, ArrayList(model))
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
    }

}