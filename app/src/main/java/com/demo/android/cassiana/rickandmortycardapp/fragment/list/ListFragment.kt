package com.demo.android.cassiana.rickandmortycardapp.fragment.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(R.layout.fragment_list) {

    private val mainViewModel: ListViewModel by viewModels()
    var listCharacters: ArrayList<Character> = ArrayList()
    var adapter = CharacterAdpater()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getCharacters()
        mainViewModel.getCharactersAlive()
        mainViewModel.getCharactersUnknow()

        mainViewModel.myCharacters.observe(viewLifecycleOwner, {
            listCharacters.addAll(it.results)
            mainViewModel.allCharacters.value = listCharacters
            getAlive()
        })
        
        recycclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycclerview.adapter = adapter
    }
    
    private fun getAlive() {
        mainViewModel.myCharactersAlive.observe(viewLifecycleOwner, {
            listCharacters.addAll(it.results)
            mainViewModel.allCharacters.value = listCharacters
            getUnknow()
        })
    }

    private fun getUnknow() {
        mainViewModel.myCharactersUnknow.observe(viewLifecycleOwner, {
            listCharacters.addAll(it.results)
            mainViewModel.allCharacters.value = listCharacters
        })

        mainViewModel.allCharacters.observe(viewLifecycleOwner, {
            Log.d("FinalSize", it.size.toString())
            adapter.getCharacters(it)
        })
    }


}