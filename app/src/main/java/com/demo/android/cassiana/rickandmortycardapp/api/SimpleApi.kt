package com.demo.android.cassiana.rickandmortycardapp.api

import com.demo.android.cassiana.rickandmortycardapp.model.CharacterList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("api/character")
    suspend fun getCharacters(@Query("page") page : Int): CharacterList

}