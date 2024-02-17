package com.app.userslistapplicationmvvmsample.navigation.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.app.userslistapplicationmvvmsample.navigation.nav_graphs.home.homeScreenNavGraph
import com.app.userslistapplicationmvvmsample.navigation.nav_graphs.splash.splashScreenNavGraph
import com.app.userslistapplicationmvvmsample.navigation.routes.ROOT_NAV_ROUTE
import com.app.userslistapplicationmvvmsample.navigation.routes.SPLASH_NAV_ROUTE

@Composable
fun RootNavGraph(navHostController: NavHostController){

    NavHost(
        navController = navHostController,
        startDestination = SPLASH_NAV_ROUTE,
        route = ROOT_NAV_ROUTE
    ){
        splashScreenNavGraph(navHostController)
        homeScreenNavGraph(navHostController)
    }
}