package com.example.retrofittesting.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittesting.service.NetworkService
import com.example.retrofittesting.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataLoaderViewModel : ViewModel() {

    private val _usersLiveData: MutableLiveData<List<User>> = MutableLiveData<List<User>>()
    val usersLiveData: LiveData<List<User>> = _usersLiveData
    private val networkService by lazy { NetworkService() }

    fun loadUsersList() {
        viewModelScope.launch(Dispatchers.IO) {
            _usersLiveData.postValue(networkService.loadUsersList())
        }
    }

}