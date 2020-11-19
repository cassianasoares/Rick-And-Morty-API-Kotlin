package com.demo.android.cassiana.rickandmortycardapp

import com.demo.android.cassiana.rickandmortycardapp.api.RetrofitInstance
import com.demo.android.cassiana.rickandmortycardapp.model.CharacterList

class Repository {
    
    suspend fun getCharacters(): CharacterList {
        return RetrofitInstance.api.getCharacters()
    }

    suspend fun getCharactersAlive(): CharacterList {
        return RetrofitInstance.api.getCharactersAlive()
    }

    suspend fun getCharactersUnknow(): CharacterList {
        return RetrofitInstance.api.getCharactersUnkown()
    }
}