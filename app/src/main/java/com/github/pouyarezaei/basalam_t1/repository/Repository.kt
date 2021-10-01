package com.github.pouyarezaei.basalam_t1.repository

import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel

interface Repository {
    suspend fun getAnimalPairFlower(): MutableList<List<InformationDomainModel>>
}