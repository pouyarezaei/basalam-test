package com.github.pouyarezaei.basalam_t1.data.dto

data class InformationDataDto(
    val id: Int,
    val image: String?,
    val name: String?
) {
    override fun toString(): String {
        return "{id : $id , image : $image , name: $name}"
    }
}