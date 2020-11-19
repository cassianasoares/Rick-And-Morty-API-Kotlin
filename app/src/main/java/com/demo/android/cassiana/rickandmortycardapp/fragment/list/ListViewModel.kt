package com.demo.android.cassiana.rickandmortycardapp.fragment.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.android.cassiana.rickandmortycardapp.Repository
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import com.demo.android.cassiana.rickandmortycardapp.model.CharacterList
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    private val repository = Repository()
    val myCharacters = MutableLiveData<CharacterList>()
    val myCharactersAlive = MutableLiveData<CharacterList>()
    val myCharactersUnknow = MutableLiveData<CharacterList>()
    var allCharacters = MutableLiveData<List<Character>>()

    fun getCharacters() {
        viewModelScope.launch{
            val response = repository.getCharacters()
            myCharacters.value = response
        }
    }
    fun getCharactersAlive() {
        viewModelScope.launch{
            val response = repository.getCharactersAlive()
            myCharactersAlive.value = response
        }
    }
    fun getCharactersUnknow() {
        viewModelScope.launch{
            val response = repository.getCharactersUnknow()
            myCharactersUnknow.value = response
        }
    }

}