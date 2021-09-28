package com.github.pouyarezaei.basalam_t1.data.util

interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel
    fun mapToDomainModel(models: List<T>): MutableList<DomainModel>
    fun mapFromDomainModel(domainModel: DomainModel): T
    fun mapFromDomainModel(domainModels: List<DomainModel>): MutableList<T>
}