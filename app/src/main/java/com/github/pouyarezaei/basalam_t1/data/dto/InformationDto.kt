package com.github.pouyarezaei.basalam_t1.data.dto

data class InformationDto(
    val `data`: List<InformationDataDto>
) {
    override fun toString(): String {
        return data.toString()
    }
}