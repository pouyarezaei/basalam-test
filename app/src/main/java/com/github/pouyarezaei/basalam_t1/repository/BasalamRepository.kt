package com.github.pouyarezaei.basalam_t1.repository

import com.github.pouyarezaei.basalam_t1.data.domain.InformationDomainModel
import com.github.pouyarezaei.basalam_t1.data.dto.InformationDataDto
import com.github.pouyarezaei.basalam_t1.data.remote.BasalamNetworkService
import com.github.pouyarezaei.basalam_t1.data.util.DomainMapper
import javax.inject.Inject

class BasalamRepository @Inject constructor(
    private val basalamNetworkService: BasalamNetworkService,
    private val domainMapper: DomainMapper<InformationDataDto, InformationDomainModel>
) : Repository {
    override suspend fun getAnimalPairFlower(): MutableList<List<InformationDomainModel>> {
        val animals = basalamNetworkService.getInformation("animal")
        val flowers = basalamNetworkService.getInformation("flower")
        val animalsDomain = domainMapper.mapToDomainModel(animals.data)
        val flowersDomain = domainMapper.mapToDomainModel(flowers.data)
        val mergeDomain = mutableListOf<InformationDomainModel>()
        mergeDomain.addAll(animalsDomain)
        mergeDomain.addAll(flowersDomain)
        val entries = mergeDomain.groupBy { it.id }.values
        return entries.toMutableList()
    }

}