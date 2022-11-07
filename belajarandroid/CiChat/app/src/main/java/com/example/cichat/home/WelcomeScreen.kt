package com.example.cichat.home


import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cichat.R
import com.example.cichat.login.LoginViewModel

//@Composable
//fun WelcomeScreen(
//    loginViewModel: LoginViewModel? = null,
////    logout():
//) {
//    val scope  = rememberCoroutineScope()
//    val context =  LocalContext.current
//    Text(text = "This Is Home")
////    Button(modifier = Modifier.fillMaxWidth().padding(20.dp),onClick = {  scope.launch { loginViewModel?.LogOut() }  }) {
//        Text(text = "Logout")
//    }
////}

@Composable
fun WelcomeScreen(viewModel: LoginViewModel) {
    Column(modifier = Modifier.padding(top = 8.dp)) {
        WelcomeText()
        LogoutButton(viewModel)
    }
}
@Composable
fun WelcomeText() {
    Text(
        text = stringResource(R.string.welcome_logged_in),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h4
    )
}


@Composable
fun LogoutButton(viewModel: LoginViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { viewModel.signOut() }) {
            Text(text = stringResource(R.string.log_out))
        }
    }
}
