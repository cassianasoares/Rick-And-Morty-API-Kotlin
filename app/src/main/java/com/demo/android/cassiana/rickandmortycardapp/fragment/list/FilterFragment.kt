package com.demo.android.cassiana.rickandmortycardapp.fragment.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.model.Character
import kotlinx.android.synthetic.main.fragment_filter.*


class FilterFragment : Fragment(R.layout.fragment_filter) {
    private val mainViewModel: ListViewModel by activityViewModels()
    var teste = listOf<Character>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_make_filter.setOnClickListener {

            mainViewModel.orderBy(mainViewModel.allCharacters.value!!)

            findNavController().navigate(R.id.action_filterFragment_to_listFragment)
        }
    }

}