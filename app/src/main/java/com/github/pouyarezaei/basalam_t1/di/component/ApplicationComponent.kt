package com.github.pouyarezaei.basalam_t1.di.component

import com.github.pouyarezaei.basalam_t1.BaseApplication
import com.github.pouyarezaei.basalam_t1.di.module.*
import com.github.pouyarezaei.basalam_t1.di.subcomponent.MainFragmentComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        SubcomponentsModule::class,
        CoreNetworkModule::class,
        NetworkServiceModule::class,
        MapperModule::class,
        Binder::class
    ],


    )
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: BaseApplication): ApplicationComponent
    }

    fun mainFragmentComponent(): MainFragmentComponent.Factory

    fun inject(baseApplication: BaseApplication)
}