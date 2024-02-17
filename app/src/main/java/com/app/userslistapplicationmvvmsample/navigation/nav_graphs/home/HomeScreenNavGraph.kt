package com.app.userslistapplicationmvvmsample.navigation.nav_graphs.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.app.userslistapplicationmvvmsample.navigation.Screens
import com.app.userslistapplicationmvvmsample.navigation.routes.USERS_NAV_ROUTE
import com.app.userslistapplicationmvvmsample.navigation.routes.USER_DETAILS_SCREEN_ROUTE
import com.app.userslistapplicationmvvmsample.navigation.routes.USER_LIST_SCREEN_ROUTE
import com.app.userslistapplicationmvvmsample.ui.user_details.UserDetails
import com.app.userslistapplicationmvvmsample.ui.users_list.UsersListScreen
import com.app.userslistapplicationmvvmsample.viewmodels.user_details.UserDetailsViewModel
import com.app.userslistapplicationmvvmsample.viewmodels.user_list.UsersViewModel

fun NavGraphBuilder.homeScreenNavGraph(
    navHostController: NavHostController
){

    navigation(startDestination = USER_LIST_SCREEN_ROUTE, route = USERS_NAV_ROUTE){

        composable(route = USER_LIST_SCREEN_ROUTE){
            val usersViewModel: UsersViewModel = hiltViewModel()
            UsersListScreen(usersViewModel,navigateToUsersDetailsScreen = { id ->
                navHostController.navigate(Screens.UserDetailsScreen.passArguments(id = id ))
            })
        }

        composable(route = USER_DETAILS_SCREEN_ROUTE, arguments = listOf(
            navArgument(
                name = "id"
            ){
                type = NavType.IntType
                defaultValue = 0
            }
        )){
            val id = it.arguments?.getInt("id")?:0
            val userDetailsViewModel:UserDetailsViewModel = hiltViewModel()
            UserDetails(id = id, viewModel = userDetailsViewModel) {
                navHostController.navigateUp()
            }
        }
    }
}