package com.app.userslistapplicationmvvmsample.network.users

import com.app.userslistapplicationmvvmsample.models.users.User
import com.app.userslistapplicationmvvmsample.models.users.UsersModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersApiService {

    //contract to fetch the users from api
    @GET("users")
    suspend fun fetchUsers(): Response<UsersModel>

    @GET("user/{id}")
    suspend fun fetchUser(@Path("id") id:Int):Response<User>

}