package com.example.cichat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation.NavHostController
import com.example.cichat.login.LoginScreen
import com.example.cichat.login.PrevSignupScreen
import com.example.cichat.login.RegisterScreen
import com.example.cichat.login.loginViewModel
import java.security.AccessController
import androidx.navigation.NavHost
import com.example.cichat.home.Home

enum class LoginRoutes{
    Signup,
    SignIn
}

enum class HomeRoutes{
    Home,
    Detail
}

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: loginViewModel
) {
    NavHost(
        navController = navController,
        startDestination = LoginRoutes.SignIn.name

    ){
        composable(route = LoginRoutes.SignIn.name){
            LoginScreen(onNavToHomePage = {
                navController.navigate(HomeRoutes.Home.name){
                    launchSingleTop = true
                    popUpTo(route = LoginRoutes.SignIn.name){
                        inclusive = true
                    }
                }
            }) {
                navController.navigate(LoginRoutes.Signup.name){
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name){
                        inclusive = true
                    }
                }
            }
        }

        composable(route = LoginRoutes.Signup.name){
            RegisterScreen(onNavToHomePage = {
                onNavToHomePage = {
                    navController.navigate(HomeRoutes.Home.name){
                        navController.navigate(HomeRoutes.Home.name){
                            popUpTo(LoginRoutes.Signup.name){
                                inclusive = true
                            }
                        }
                    }
                }
            }) {
                navController.navigate(LoginRoutes.SignIn.name)

            }
        }

        composable(route = HomeRoutes.Home.name){
            Home()
        }
    }
    
    
    
    
    
    
}


