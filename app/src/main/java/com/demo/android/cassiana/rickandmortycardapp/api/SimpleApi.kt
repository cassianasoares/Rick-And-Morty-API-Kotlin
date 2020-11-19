package com.demo.android.cassiana.rickandmortycardapp.api

import com.demo.android.cassiana.rickandmortycardapp.model.CharacterList
import retrofit2.http.GET

interface SimpleApi {

    @GET("api/character/?status=dead&page=1")
    suspend fun getCharacters(): CharacterList

    @GET("api/character/?status=alive&page=1")
    suspend fun getCharactersAlive(): CharacterList

    @GET("api/character/?status=unknown&page=1")
    suspend fun getCharactersUnkown(): CharacterList

}