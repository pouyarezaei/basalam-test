package com.github.pouyarezaei.basalam_t1

import androidx.multidex.MultiDexApplication
import com.github.pouyarezaei.basalam_t1.di.component.ApplicationComponent
import com.github.pouyarezaei.basalam_t1.di.component.DaggerApplicationComponent

class BaseApplication : MultiDexApplication() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this@BaseApplication)
            .also { it.inject(this@BaseApplication) }

    }
}