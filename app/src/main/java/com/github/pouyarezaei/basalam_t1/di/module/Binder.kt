package com.github.pouyarezaei.basalam_t1.di.module

import android.app.Application
import android.content.Context
import com.github.pouyarezaei.basalam_t1.BaseApplication
import dagger.Binds
import dagger.Module

@Module
abstract class Binder {
    @Binds
    abstract fun bindContext(application: BaseApplication): Context

    @Binds
    abstract fun bindApplication(application: BaseApplication): Application
}