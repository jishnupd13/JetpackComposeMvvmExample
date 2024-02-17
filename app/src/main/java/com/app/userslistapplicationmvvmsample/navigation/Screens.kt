package com.app.userslistapplicationmvvmsample.navigation

import com.app.userslistapplicationmvvmsample.navigation.routes.SPLASH_NAV_ROUTE
import com.app.userslistapplicationmvvmsample.navigation.routes.USER_DETAILS_SCREEN_ROUTE
import com.app.userslistapplicationmvvmsample.navigation.routes.USER_LIST_SCREEN_ROUTE

sealed class Screens(val route:String) {

    data object SplashScreen:Screens(SPLASH_NAV_ROUTE)

    data object UserListScreen:Screens(USER_LIST_SCREEN_ROUTE)

    data object UserDetailsScreen:Screens(USER_DETAILS_SCREEN_ROUTE){
        fun passArguments(id:Int):String{
            val route = USER_DETAILS_SCREEN_ROUTE.split("?").firstOrNull()
            return "$route?id=$id"
        }
    }

}