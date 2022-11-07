package com.example.cichat

import androidx.navigation.Navigation
import androidx.compose.runtime.State


enum class NavigationEnum (val title: Int) {
    Login(
        title = R.string.login
    ),
    Register(
      title = R.string.Register
    ),
    EmailLogin(
        title = R.string.sign_in_with_email
    ),
    Welcome(
        title = R.string.welcome
    );

    companion object{
        fun formRoute(route: String?, isLoggedIn: State<Boolean>) : NavigationEnum {
            return if (!isLoggedIn.value) {
                when (route?.substringBefore("/")) {
                    Login.name -> Login
                    EmailLogin.name -> EmailLogin
                    Register.name -> Register
                    else -> Login // redirect to login if some other page, but not logged in
                }
            } else {
                // Define here login route
                when (route?.substringBefore("/")) {
                    Welcome.name -> Welcome
                    Login.name -> Welcome
                    Register.name -> Register
                    EmailLogin.name -> Welcome
                    null -> Welcome
                    else -> throw java.lang.IllegalArgumentException("Route $route is not recognized")
                }
            }
        }
    }







}