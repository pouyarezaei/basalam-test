package com.github.pouyarezaei.basalam_t1

import android.app.Application
import com.github.pouyarezaei.basalam_t1.di.component.ApplicationComponent
import com.github.pouyarezaei.basalam_t1.di.component.DaggerApplicationComponent

class BaseApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this@BaseApplication)
            .also { it.inject(this@BaseApplication) }

    }
}