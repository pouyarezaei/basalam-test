package com.github.pouyarezaei.basalam_t1.data.domain

import android.os.Parcel
import android.os.Parcelable

data class InformationDomainModel(
    val id: Int,
    val image: String?,
    val name: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "{id : $id , image : $image , name: $name}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InformationDomainModel> {
        override fun createFromParcel(parcel: Parcel): InformationDomainModel {
            return InformationDomainModel(parcel)
        }

        override fun newArray(size: Int): Array<InformationDomainModel?> {
            return arrayOfNulls(size)
        }
    }
}