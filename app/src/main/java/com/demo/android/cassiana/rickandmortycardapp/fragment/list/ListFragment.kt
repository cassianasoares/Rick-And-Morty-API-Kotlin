package com.demo.android.cassiana.rickandmortycardapp.fragment.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import kotlinx.android.synthetic.main.fragment_list.*
import java.util.Arrays.asList


class ListFragment : Fragment(R.layout.fragment_list) {

    private val mainViewModel: ListViewModel by activityViewModels()
    var adapter = CharacterAdpater()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.filterCharacters.observe(viewLifecycleOwner, {
            adapter.setCharacters(it)
        })

        recycclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycclerview.adapter = adapter

        btn_filter.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
        }
    }

}