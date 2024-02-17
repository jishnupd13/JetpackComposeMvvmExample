package com.app.userslistapplicationmvvmsample.ui.users_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.userslistapplicationmvvmsample.ui.components.ErrorScreen
import com.app.userslistapplicationmvvmsample.ui.components.ProgressBar
import com.app.userslistapplicationmvvmsample.ui.components.SimpleTopBar
import com.app.userslistapplicationmvvmsample.ui.components.UsersItem
import com.app.userslistapplicationmvvmsample.utils.NetworkResult
import com.app.userslistapplicationmvvmsample.viewmodels.user_list.UsersViewModel

@Composable
fun UsersListScreen(
    viewModel: UsersViewModel,
    navigateToUsersDetailsScreen:(id:Int)->Unit
){
    val usersListState = viewModel.userMutableStateFlow.collectAsState()
    LaunchedEffect(key1 = Unit){
        viewModel.fetchUsers()
    }


    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        SimpleTopBar(title = "Users", isHideBackButton = true)

        when(usersListState.value){

            is NetworkResult.Loading ->{
               ProgressBar()
            }

            is NetworkResult.Success ->{
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(14.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        items(usersListState.value.data?.users?: emptyList()){
                            UsersItem(it){item->
                                navigateToUsersDetailsScreen.invoke(item?.id?:0)
                            }
                        }
                    })
            }

            is NetworkResult.Error ->{
                ErrorScreen()
            }
        }
    }
}





@Composable
@Preview(showSystemUi = true, showBackground = true)
fun UsersListScreenPreview(){
    val hitViewModel: UsersViewModel = hiltViewModel()
    UsersListScreen(hitViewModel,navigateToUsersDetailsScreen = {})
}
