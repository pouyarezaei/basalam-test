package com.github.pouyarezaei.basalam_t1.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.github.pouyarezaei.basalam_t1.R
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel

class DetailsPagerFragment(private val informationDomainModel: InformationDomainModel) :
    Fragment(R.layout.details_slider_item) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val circularProgressDrawable = CircularProgressDrawable(requireContext()).apply {
            this.strokeWidth = 5f
            this.centerRadius = 30f
            this.start()
        }
        Glide.with(this).load(informationDomainModel.image)
            .placeholder(circularProgressDrawable)
            .apply(RequestOptions.bitmapTransform(GranularRoundedCorners(0f, 0f, 16f, 16f)))
            .into(view.findViewById(R.id.details_slider_image))
    }
}