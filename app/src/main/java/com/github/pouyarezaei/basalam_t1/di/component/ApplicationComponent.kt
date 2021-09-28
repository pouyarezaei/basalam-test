package com.github.pouyarezaei.basalam_t1.di.component

import com.github.pouyarezaei.basalam_t1.BaseApplication
import com.github.pouyarezaei.basalam_t1.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: BaseApplication): ApplicationComponent
    }

    fun inject(baseApplication: BaseApplication)
}