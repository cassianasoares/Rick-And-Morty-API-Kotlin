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
        val characters: ArrayList<Character>? = ArrayList()
        for (item in status){
            viewModelScope.launch{
                val response = repository.getCharacters(item)
                characters!!.addAll(response.results)
                allCharacters.value = characters
            }
       }
    }


    fun orderBy(list: List<Character>){
        val characters= list.filter{it.status == "unknown"}//episode.size in 3..6}
        val sorted = characters.sortedBy { it.id }
//        val listchar = arrayListOf<Character>()
        Log.d("Filter", characters.size.toString())
//        for(item in characters){
//            if(item.status == "unknown" || item.status == "Dead"){
//                listchar.add(item)
//            }
//        }
        filterCharacters.value = sorted
    }

}