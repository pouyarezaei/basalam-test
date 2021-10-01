package com.github.pouyarezaei.basalam_t1.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.pouyarezaei.basalam_t1.R
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel
import com.github.pouyarezaei.basalam_t1.util.findDuplicateCharsCount

class MainRecyclerAdapter(
    private val recyclerClick: RecyclerViewItemClick<List<InformationDomainModel>>
) : RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {
    private var items: MutableList<List<InformationDomainModel>> = ArrayList()


    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            model: List<InformationDomainModel>,
            recyclerClick: RecyclerViewItemClick<List<InformationDomainModel>>
        ) {
            itemView.findViewById<TextView>(R.id.recycler_item_title).text =
                itemView.context.getString(
                    R.string.recycler_item_title_format,
                    model.first().name,
                    model.last().name
                )
            itemView.findViewById<TextView>(R.id.recycler_item_subtitle).text =
                itemView.context.getString(
                    R.string.recycler_item_subtitle_format,
                    model.first().name?.findDuplicateCharsCount(model.last().name!!)
                )
            itemView.findViewById<Button>(R.id.recycler_item_show_button)
                .setOnClickListener { recyclerClick.click(model) }
            Glide.with(itemView).load(model.first().image)
                .into(itemView.findViewById(R.id.recycler_item_back_img))
            Glide.with(itemView).load(
                model.last().image
            ).into(itemView.findViewById(R.id.recycler_item_front_img))
        }
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

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: MutableList<List<InformationDomainModel>>) {
        this.items = items
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun appendItems(items: MutableCollection<List<InformationDomainModel>>) {
        this.items.addAll(items)
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        items.elementAtOrNull(position)?.let { holder.bind(it, recyclerClick) }
    }

    interface RecyclerViewItemClick<T> {
        fun click(model: T)
    }
}