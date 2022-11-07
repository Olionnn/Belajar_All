package com.example.cichat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.navigation.compose.NavHost
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cichat.home.WelcomeScreen
import com.example.cichat.login.*
//import com.example.cichat.login.
import com.example.cichat.ui.theme.CiChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//                val LoginViewModel = viewModels<ViewModel>(modelClass = LoginViewModel::class.java)
            CiChatTheme {
//                    Navigation(LoginViewModel = LoginViewModel())
//                mainNav(LoginViewModel = LoginViewModel())

                BaseScreen()
            }
        }
    }
}


@SuppressLint("SuspiciousIndentation")
@Composable
fun BaseScreen(LoginViewModel: LoginViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    val backstackEntry = navController.currentBackStackEntryAsState()
    val currentScreen =
        NavigationEnum.formRoute(backstackEntry.value?.destination?.route,LoginViewModel.isLoggedIn)
            Scaffold(
                topBar = ({
                    if (currentScreen == NavigationEnum.Login) {
                        Modifier.background(color = Color.Transparent)
                    } else{
                    TopBar(navController, currentScreen)
                    }
                }),

                content = {
                    NavigationBetweenScreen(navController)
                }
            )
}

@Composable
fun TopBar(navController: NavHostController, currentScreen: NavigationEnum) {
    TopAppBar(
        title = {
            Text(text = stringResource(currentScreen.title))
        },
        navigationIcon = {
            if (currentScreen != NavigationEnum.Welcome && currentScreen != NavigationEnum.Login) {
                NavigationBackButton(navController)
            }
        }
    )
}

@Composable
fun NavigationBackButton(navController: NavHostController) {
    IconButton(
        onClick = { navController.popBackStack() },
        modifier = Modifier.semantics { contentDescription = "back button" }) {
        Icon(Icons.Filled.ArrowBack, stringResource(id = R.string.back_icon) )
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavigationBetweenScreen(navController: NavHostController, LoginViewModel: LoginViewModel = hiltViewModel()) {
    val startDestination = if (LoginViewModel.isLoggedIn.value)
        NavigationEnum.Welcome.name else NavigationEnum.Login.name

        NavHost(navController = navController, startDestination = startDestination) {
            loginPage(this, navController, LoginViewModel)
            emailLoginPage(this, navController, LoginViewModel)
            registerPage(this, navController, LoginViewModel)
            welcomePage(this, LoginViewModel)
        }
}

    private fun loginPage(builder: NavGraphBuilder, navController: NavHostController, LoginViewModel: LoginViewModel) {
        builder.composable(route = NavigationEnum.Login.name) {
            LoginScreen(emailLoginClick = {
                navController.navigate(NavigationEnum.EmailLogin.name)
            },
              registerCreateClick = {
                  navController.navigate(
                      NavigationEnum.Register.name
                  )

              },
                viewModel = LoginViewModel
                )
        }
    }

    private fun registerPage(builder: NavGraphBuilder, navController: NavHostController, LoginViewModel: LoginViewModel) {
        builder.composable(route = NavigationEnum.Register.name) {
            EmailRegisterScreen(LoginViewModel)
        }
    }

    fun emailLoginPage(builder: NavGraphBuilder, navController: NavHostController, LoginViewModel: LoginViewModel) {
        builder.composable(route = NavigationEnum.EmailLogin.name) {
            EmailLoginScreen(LoginViewModel)
        }
    }

    fun welcomePage(builder: NavGraphBuilder, LoginViewModel: LoginViewModel) {
        builder.composable(route = NavigationEnum.Welcome.name) {
            WelcomeScreen(LoginViewModel)
        }
    }