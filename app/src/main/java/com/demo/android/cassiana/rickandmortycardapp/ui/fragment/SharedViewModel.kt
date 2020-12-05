package com.demo.android.cassiana.rickandmortycardapp.ui.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.android.cassiana.rickandmortycardapp.api.Repository
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import kotlinx.coroutines.launch

class SharedViewModel(private val repository: Repository): ViewModel() {

    var listCharactersInEpisode = MutableLiveData<List<Character>>()
    var filterValue = MutableLiveData<Array<Int>>()

    init {
        filterValue.value = arrayOf(-1, -1)
    }

    fun getCharacters(page: Int) {
        viewModelScope.launch{
            val characters = repository.getCharacters(page)
            listCharactersInEpisode.value = characters.results
        }
    }

    fun getByName(name: String){
        viewModelScope.launch{
            val characters = repository.getCharactersByName(name)
            listCharactersInEpisode.value = characters.results
        }
    }

    fun getByStatusAndGender(status : String, gender: String, page:Int){
        viewModelScope.launch{
            val characters = repository.getCharactersbyStatusAndGender(status, gender, page)
            listCharactersInEpisode.value = characters.results
        }
    }

    fun getByStatus(status : String, page:Int){
        viewModelScope.launch{
            val characters = repository.getCharactersByStatus(status, page)
            listCharactersInEpisode.value = characters.results
        }
    }

    fun getByGender(gender: String, page:Int){
        viewModelScope.launch{
            val characters = repository.getCharactersByGender(gender, page)
            listCharactersInEpisode.value = characters.results
        }
    }


}