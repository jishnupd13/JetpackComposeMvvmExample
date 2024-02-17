package com.app.userslistapplicationmvvmsample.repository.users

import com.app.userslistapplicationmvvmsample.network.users.UsersApiService
import com.app.userslistapplicationmvvmsample.utils.safeApiCall
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val userApiService: UsersApiService
)  {

    suspend fun fetchUsers() = safeApiCall { userApiService.fetchUsers() }

    suspend fun fetchUser(id:Int) = safeApiCall { userApiService.fetchUser(id = id) }

}