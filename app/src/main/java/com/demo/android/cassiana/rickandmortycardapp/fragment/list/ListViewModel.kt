package com.demo.android.cassiana.rickandmortycardapp.fragment.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.android.cassiana.rickandmortycardapp.Repository
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    private val repository = Repository()
    var allCharacters = MutableLiveData<List<Character>>()
    var filterCharacters = MutableLiveData<List<Character>>()

    fun getCharacters(status: Array<Int>) {
        val characters: ArrayList<Character> = ArrayList()
        for (item in status){
            viewModelScope.launch{
                val response = repository.getCharacters(item)
                characters.addAll(response.results)
                allCharacters.value = characters
            }
       }
    }

    fun orderByStatus(list: List<Character>, condition: MutableList<CharSequence>): List<Character>{
        val characters = arrayListOf<Character>()
        for(item in condition) {
            //Log.d("RecebidoView", item.toString())
            characters.addAll(list.filter { it.status == item })
        }
        Log.d("Filter", characters.size.toString())
        return characters.sortedBy { it.id }
    }

    fun orderByGender(list: List<Character>, condition: MutableList<CharSequence>): List<Character>{
        val characters = arrayListOf<Character>()
        for(item in condition) {
            characters.addAll(list.filter { it.gender == item })//episode.size in 3..6}
        }
        Log.d("Filter", characters.size.toString())
        return characters.sortedBy { it.id }
    }

}