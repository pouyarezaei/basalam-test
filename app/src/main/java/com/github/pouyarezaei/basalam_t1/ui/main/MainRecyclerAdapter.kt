package com.github.pouyarezaei.basalam_t1.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.pouyarezaei.basalam_t1.R
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel

class MainRecyclerAdapter(
    private val items: List<List<InformationDomainModel>>,
    private val recyclerClick: RecyclerViewItemClick<List<InformationDomainModel>>
) : RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {


    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            model: List<InformationDomainModel>,
            recyclerClick: RecyclerViewItemClick<List<InformationDomainModel>>
        ) {
            recyclerClick.click(model)
            // TODO binding views
        }
    }

    interface RecyclerViewItemClick<T> {
        fun click(model: T)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.main_recycler_item, parent, false);
        return MainViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position], recyclerClick)
    }

}