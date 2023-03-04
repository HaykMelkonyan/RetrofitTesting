package com.example.retrofittesting.service

import com.example.retrofittesting.entity.User
import retrofit2.Call
import retrofit2.http.GET


interface UsersApi {
    @GET("public/v2/users")
    fun getUsers(): Call<List<User>>
}
