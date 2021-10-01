package com.github.pouyarezaei.basalam_t1.di.module

import android.app.Application
import android.content.Context
import com.github.pouyarezaei.basalam_t1.BaseApplication
import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel
import com.github.pouyarezaei.basalam_t1.data.domain.InformationMapper
import com.github.pouyarezaei.basalam_t1.data.dto.InformationDataDto
import com.github.pouyarezaei.basalam_t1.data.util.DomainMapper
import com.github.pouyarezaei.basalam_t1.repository.BasalamRepository
import com.github.pouyarezaei.basalam_t1.repository.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class Binder {
    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun bindApplication(baseApplication: BaseApplication): Application

    @Binds
    internal abstract fun bindInformationMapper(informationMapper: InformationMapper): DomainMapper<InformationDataDto, InformationDomainModel>

    @Binds
    internal abstract fun bindBasalamRepository(basalamRepository: BasalamRepository): Repository
}