package com.app.userslistapplicationmvvmsample.navigation.nav_graphs.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.userslistapplicationmvvmsample.navigation.Screens
import com.app.userslistapplicationmvvmsample.navigation.routes.SPLASH_NAV_ROUTE
import com.app.userslistapplicationmvvmsample.navigation.routes.SPLASH_SCREEN_ROUTE
import com.app.userslistapplicationmvvmsample.ui.splash.SplashScreen


fun NavGraphBuilder.splashScreenNavGraph(
    navHostController: NavHostController
){

    navigation(startDestination = SPLASH_SCREEN_ROUTE, route = SPLASH_NAV_ROUTE){
        composable(route = SPLASH_SCREEN_ROUTE){
            SplashScreen {
                navHostController.navigate(Screens.UserListScreen.route){
                    popUpTo(Screens.SplashScreen.route)
                }
            }
        }
    }
}