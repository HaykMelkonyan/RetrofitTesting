package com.example.retrofittesting.service

import com.example.retrofittesting.entity.User

class NetworkService {
    private val retrofit by lazy { RetrofitHelper.getInstance() }
    fun loadUsersList(): List<User> {
        val apiService = retrofit.create(UsersApi::class.java)
        return apiService.getUsers().execute().body() ?: throw Exception("user not found")
    }
}

