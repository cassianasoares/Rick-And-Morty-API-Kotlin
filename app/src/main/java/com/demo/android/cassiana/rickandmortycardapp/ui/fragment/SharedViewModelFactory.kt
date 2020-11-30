package com.demo.android.cassiana.rickandmortycardapp.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.android.cassiana.rickandmortycardapp.api.Repository

class SharedViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
     return SharedViewModel(repository) as T
    }
}