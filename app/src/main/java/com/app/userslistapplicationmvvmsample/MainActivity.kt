package com.app.userslistapplicationmvvmsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.app.userslistapplicationmvvmsample.navigation.nav_graphs.RootNavGraph
import com.app.userslistapplicationmvvmsample.network.users.UsersApiService
import com.app.userslistapplicationmvvmsample.ui.theme.UsersListApplicationMvvmSampleTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//api users - https://dummyjson.com/docs/users
//https://www.youtube.com/watch?v=eBNwQqirB8c

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @Inject
    lateinit var apiService: UsersApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersListApplicationMvvmSampleTheme {
                RootNavGraph(navHostController = rememberNavController())
            }
        }
    }
}

