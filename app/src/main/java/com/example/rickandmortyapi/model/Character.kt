package com.example.rickandmortyapi.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    var id : Int,
    var name : String,
    var status : String,
    var species : String,
    var type : String,
    var gender : String,
    var origin : LocationData,
    var location : LocationData,
    var imageUrl : String,
    var episode : List<String>,
    var url : String,
    var created : String
        ): Parcelable