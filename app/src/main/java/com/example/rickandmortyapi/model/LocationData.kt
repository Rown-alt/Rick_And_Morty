package com.example.rickandmortyapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationData(
    var name : String,
    var ulr : String
) : Parcelable