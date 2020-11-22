package com.demo.android.cassiana.rickandmortycardapp

import com.demo.android.cassiana.rickandmortycardapp.api.RetrofitInstance
import com.demo.android.cassiana.rickandmortycardapp.model.CharacterList

class Repository {
    
    suspend fun getCharacters(page: Int): CharacterList {
        return RetrofitInstance.api.getCharacters(page)
    }

}