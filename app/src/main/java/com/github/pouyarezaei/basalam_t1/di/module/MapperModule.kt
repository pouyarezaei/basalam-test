package com.github.pouyarezaei.basalam_t1.di.module

import com.github.pouyarezaei.basalam_t1.data.domain.InformationMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {
    @Provides
    fun provideInformationMapper(): InformationMapper {
        return InformationMapper()
    }

}