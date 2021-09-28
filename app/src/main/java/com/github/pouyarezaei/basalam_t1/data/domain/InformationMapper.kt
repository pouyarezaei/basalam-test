package com.github.pouyarezaei.basalam_t1.data.domain

import com.github.pouyarezaei.basalam_t1.data.dto.InformationDataDto
import com.github.pouyarezaei.basalam_t1.data.util.DomainMapper

class InformationMapper : DomainMapper<InformationDataDto, InformationDomainModel> {
    override fun mapToDomainModel(model: InformationDataDto): InformationDomainModel {
        return InformationDomainModel(
            id = model.id,
            name = model.name,
            image = model.image,
        )
    }

    override fun mapFromDomainModel(domainModel: InformationDomainModel): InformationDataDto {
        return InformationDataDto(
            id = domainModel.id,
            name = domainModel.name,
            image = domainModel.image,
        )
    }

    override fun mapToDomainModel(models: List<InformationDataDto>): MutableList<InformationDomainModel> {
        return models.map {
            this.mapToDomainModel(it)
        }.toMutableList()
    }

    override fun mapFromDomainModel(domainModels: List<InformationDomainModel>): MutableList<InformationDataDto> {
        return domainModels.map {
            this.mapFromDomainModel(it)
        }.toMutableList()
    }
}