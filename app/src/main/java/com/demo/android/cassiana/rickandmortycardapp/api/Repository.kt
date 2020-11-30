package com.demo.android.cassiana.rickandmortycardapp.api

import com.demo.android.cassiana.rickandmortycardapp.model.CharacterList

class Repository {
    
    suspend fun getCharacters(page: Int): CharacterList {
        return RetrofitInstance.api.getCharacters(page)
    }

    suspend fun getCharactersByName(name: String): CharacterList{
        return RetrofitInstance.api.getCharactersByName(name)
    }

    suspend fun getCharactersbyStatusAndGender(status : String, gender: String, page:Int): CharacterList{
        return RetrofitInstance.api.getCharactersbyStatusAndGender(status, gender, page)
    }

    suspend fun getCharactersByStatus(status : String, page:Int): CharacterList{
        return RetrofitInstance.api.getCharactersByStatus(status, page)
    }

    suspend fun getCharactersByGender(gender : String, page:Int): CharacterList{
        return RetrofitInstance.api.getCharactersByGender(gender, page)
    }
}