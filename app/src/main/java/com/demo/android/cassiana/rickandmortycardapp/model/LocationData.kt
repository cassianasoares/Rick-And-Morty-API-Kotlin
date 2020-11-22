package com.demo.android.cassiana.rickandmortycardapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationData (
    var name : String,
    var url : String
): Parcelable