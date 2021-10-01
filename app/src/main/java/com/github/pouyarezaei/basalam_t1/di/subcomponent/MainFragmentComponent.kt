package com.github.pouyarezaei.basalam_t1.di.subcomponent

import com.github.pouyarezaei.basalam_t1.di.scope.FragmentScope
import com.github.pouyarezaei.basalam_t1.ui.main.MainFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [])
interface MainFragmentComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainFragmentComponent
    }

    fun inject(mainFragment: MainFragment)

}