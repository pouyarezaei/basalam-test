package com.github.pouyarezaei.basalam_t1.ui.main

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.pouyarezaei.basalam_t1.BaseApplication
import com.github.pouyarezaei.basalam_t1.MainActivity
import com.github.pouyarezaei.basalam_t1.R
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel
import javax.inject.Inject


class MainFragment : Fragment(R.layout.main_fragment),
    MainRecyclerAdapter.RecyclerViewItemClick<List<InformationDomainModel>> {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mainRecyclerView: RecyclerView
    lateinit var mainLoadingProgressBar: ProgressBar
    lateinit var mainRecyclerViewAdapter: MainRecyclerAdapter
    lateinit var viewmodel: MainViewModel


    override fun onAttach(context: Context) {
        (context.applicationContext as BaseApplication).applicationComponent.mainFragmentComponent()
            .create().inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.handleEvent(MainEvent.Load)

        (requireActivity() as MainActivity).toolbarText.text = context?.getString(
            R.string.main_fragment_title,
        )

        mainRecyclerView = view.findViewById(R.id.main_recycler_view)
        mainLoadingProgressBar = view.findViewById(R.id.main_loading_indicator)

        mainLoadingProgressBar.visibility = View.VISIBLE
        mainRecyclerView.visibility = View.GONE
        mainRecyclerViewAdapter = MainRecyclerAdapter(this)
        mainRecyclerView.adapter = mainRecyclerViewAdapter


        (requireActivity() as MainActivity).toolbarBackButton.setOnClickListener {
            requireActivity().finish()
        }

        viewmodel.observeNetworkState().observe(viewLifecycleOwner, {
            if (it == true) {
                viewmodel.observeData().observe(viewLifecycleOwner, {
                    mainRecyclerViewAdapter.setItems(it)
                    mainRecyclerView.visibility = View.VISIBLE
                    mainLoadingProgressBar.visibility = View.GONE
                })
            } else {
                AlertDialog.Builder(context)
                    .setTitle("Connectivity Error")
                    .setMessage("check your internet connection.")
                    .setPositiveButton(
                        "retry"
                    ) { dialog, which ->
                        viewmodel.handleEvent(MainEvent.Load)
                    }
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()
            }
        })

    }

    override fun click(model: List<InformationDomainModel>) {
        val bundle = Bundle()
        bundle.putParcelableArrayList("data", ArrayList(model))
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
    }

}