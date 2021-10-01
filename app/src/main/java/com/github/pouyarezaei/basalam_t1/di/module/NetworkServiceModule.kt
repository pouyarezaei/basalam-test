package com.github.pouyarezaei.basalam_t1.di.module

import com.github.pouyarezaei.basalam_t1.data.remote.BasalamNetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class NetworkServiceModule {

    @Singleton
    @Provides
    fun provideBasalamNetworkService(retrofit: Retrofit): BasalamNetworkService {
        return retrofit.create(BasalamNetworkService::class.java)
    }
}