package com.github.pouyarezaei.basalam_t1.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.pouyarezaei.basalam_t1.R
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel
import com.github.pouyarezaei.basalam_t1.ui.main.MainFragment

class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val viewModel: DetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}