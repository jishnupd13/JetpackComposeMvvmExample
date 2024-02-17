package com.app.userslistapplicationmvvmsample.viewmodels.user_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.userslistapplicationmvvmsample.models.users.User
import com.app.userslistapplicationmvvmsample.repository.users.UsersRepository
import com.app.userslistapplicationmvvmsample.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel(){

    private val _usersMutableStateFlow : MutableStateFlow<NetworkResult<User>> = MutableStateFlow(
        NetworkResult.Loading())
    val userMutableStateFlow: StateFlow<NetworkResult<User>> = _usersMutableStateFlow

    //Api to fetch the users in android ...
    fun fetchUsers(id:Int) = viewModelScope.launch {
        _usersMutableStateFlow.emit(repository.fetchUser(id = id))
    }
}