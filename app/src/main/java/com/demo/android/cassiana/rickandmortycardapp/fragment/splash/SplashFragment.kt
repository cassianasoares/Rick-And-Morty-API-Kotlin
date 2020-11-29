package com.demo.android.cassiana.rickandmortycardapp.fragment.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.demo.android.cassiana.rickandmortycardapp.R
import com.demo.android.cassiana.rickandmortycardapp.fragment.SharedViewModel


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel: SharedViewModel by activityViewModels()
    val listStatus = arrayOf(1, 2, 3)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCharacters(listStatus)

        viewModel.allCharacters.observe(viewLifecycleOwner, {
            if(it.size == (20 * listStatus.size)){
                //val sorted = it.sortedBy{it.id}
                viewModel.filterCharacters.value = it
                findNavController().navigate(R.id.action_splashFragment_to_listFragment)
            }
        })

    }


}