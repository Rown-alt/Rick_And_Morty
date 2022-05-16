package com.example.rickandmortyapi.api

import com.example.rickandmortyapi.model.Character
import com.example.rickandmortyapi.model.CharacterList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {
    @GET("character")
    suspend fun getCharacters(@Query("page") page : Int) : CharacterList
    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") characterId : Int) : Character
}