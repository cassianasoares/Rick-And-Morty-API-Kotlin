package com.demo.android.cassiana.rickandmortycardapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.fragment.list.ListViewModel
import kotlinx.coroutines.delay


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val mainViewModel: ListViewModel by activityViewModels()
    val listStatus = arrayOf(1, 2, 3)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getCharacters(listStatus)

        mainViewModel.allCharacters.observe(viewLifecycleOwner, {
            if(it.size == 60){
                val sorted = it.sortedBy{it.id}
                mainViewModel.filterCharacters.value = sorted
                findNavController().navigate(R.id.action_splashFragment_to_listFragment)
            }
        })

    }


}