package com.example.cichat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cichat.login.loginViewModel
import com.example.cichat.ui.theme.CiChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//                val loginViewModel = viewModels<ViewModel>(modelClass = LoginViewModel::class.java)
            CiChatTheme {
//                    Navigation(loginViewModel = loginViewModel())
                mainNav(loginViewModel = loginViewModel())
            }
        }
    }
}


