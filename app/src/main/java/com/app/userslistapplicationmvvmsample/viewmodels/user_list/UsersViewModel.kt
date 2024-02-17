package com.app.userslistapplicationmvvmsample.viewmodels.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.userslistapplicationmvvmsample.models.users.UsersModel
import com.app.userslistapplicationmvvmsample.repository.users.UsersRepository
import com.app.userslistapplicationmvvmsample.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    private val _usersMutableStateFlow :MutableStateFlow<NetworkResult<UsersModel>> = MutableStateFlow(NetworkResult.Loading())
    val userMutableStateFlow:StateFlow<NetworkResult<UsersModel>> = _usersMutableStateFlow

    //Api to fetch the users in android ...
    fun fetchUsers() = viewModelScope.launch {
        _usersMutableStateFlow.emit(repository.fetchUsers())
    }

}