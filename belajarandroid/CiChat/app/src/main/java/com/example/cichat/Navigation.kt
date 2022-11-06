package com.example.cichat

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.cichat.login.LoginScreen
import com.example.cichat.login.RegisterScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
//import androidx.navigation.
import androidx.navigation.compose.rememberNavController
import com.example.cichat.home.Home
import com.example.cichat.login.loginViewModel

enum class LoginRoutes{
    Signup,
    SignIn,
//    LogOut,
}

enum class HomeRoutes{
    Home,
    Detail,
    LogOut
}

@Composable
fun mainNav(
    navController: NavHostController = rememberNavController(),
    loginViewModel: loginViewModel,
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
            },
                loginViewModel = loginViewModel
            ) {
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
                    navController.navigate(HomeRoutes.Home.name){
                        navController.navigate(HomeRoutes.Home.name){
                            popUpTo(LoginRoutes.Signup.name){
                                inclusive = true
                            }
                        }
                    }
            },
                loginViewModel = loginViewModel,
                ) {
                navController.navigate(LoginRoutes.SignIn.name)

            }
        }

        composable(route = HomeRoutes.Home.name){
            Home(logout = {navController.navigate(LoginRoutes.SignIn.name) {
                popUpTo(HomeRoutes.Home.name)
            } })
        }

//        composable(route = HomeRoutes.LogOut.name){
//            Home(logout = {navController.navigate(LoginRoutes.SignIn.name)}, loginViewModel = loginViewModel,)
//        }
    }
    
    
    
    
    

}


