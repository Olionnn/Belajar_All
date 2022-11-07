package com.example.cichat.login


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import com.example.cichat.R
import com.example.cichat.ui.theme.CiChatTheme

private const val TAG = "LoginScreen"

@Composable
fun LoginScreen(
    emailLoginClick: () -> Unit,
    registerCreateClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
//    val loginUiState = LoginViewModel?.loginUiState
//    val isError = loginUiState?.loginError != null
//    val context = LocalContext.current

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome To CiChat",
            modifier = Modifier
                .fillMaxWidth()
                ,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary,
//            textDecoration = MaterialTheme.colors.primary
        )
//        val buttonWidtd = Modifier.fillMaxWidth()

        Spacer(modifier = Modifier.height(18.dp))

        if (viewModel.error.value.isNotBlank()) {
            ErrorField(viewModel)
        }
        Card(
            modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth()
//                .fillMaxHeight(1f)
                .padding(15.dp)
                .clip(
                    RoundedCornerShape(15.dp, 15.dp)
                )
                .shadow(5.dp),
        ) {
            Column(
                modifier = Modifier.background(MaterialTheme.colors.secondary)
            ) {
            SignInWithEmailButton(emailLoginClick)

            RegisterWithEmailButton(registerCreateClick)
            }
        }


//        SignInWithGoogleButton(buttonWidth, viewModel)
    }
}







//@Composable
//fun RegisterScreen(
//    registerCreateClick: () -> Unit,
//    viewModel: LoginViewModel = hiltViewModel()
//) {
////    val loginUiState = LoginViewModel?.loginUiState
////    val isError = loginUiState?.loginError != null
////    val context = LocalContext.current
//
//    Column(
//        modifier = Modifier
//            .verticalScroll(rememberScrollState())
//            .padding(24.dp)
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.spacedBy(18.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        val buttonWidtd = 300.dp
//
//        Spacer(modifier = Modifier.height(18.dp))
//
//        if (viewModel.error.value.isNotBlank()) {
//            ErrorField(viewModel)
//        }
//
////        SignInWithGoogleButton(buttonWidth, viewModel)
//    }
//}


//@Composable
//fun SignInWithGoogleButton(buttonWidth: Any, viewModel: LoginViewModel) {
//
//}

@Composable
fun ErrorField(viewModel: LoginViewModel) {
    Text(
        text = viewModel.error.value,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Red,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun RegisterWithEmailButton(registerCreateClick: () -> Unit) {
    OutlinedButton(
        onClick = { registerCreateClick() },
        modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.fui_bgEmail),
            contentColor = colorResource(id = R.color.white)
        )
    ) {
        RegisterButtonRow(iconId = R.drawable.ic_baseline_create_24, buttonTextId= R.string.Register)
    }

}

@Composable
fun RegisterButtonRow(@DrawableRes iconId: Int, @StringRes buttonTextId: Int) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp)
    ) {
        RegisterButtonIcon(iconId)
        RegisterButtonText(buttonTextId)
    }
}

@Composable
fun RegisterButtonText(@StringRes stringResourceId: Int) {
    Text(
        text = stringResource(stringResourceId),
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.button,
        modifier = Modifier
            .padding(start = 5.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
    )
}

@Composable
fun RegisterButtonIcon(@DrawableRes painterResourceId: Int) {
    Icon(
        tint = Color.Unspecified,
        painter = painterResource(id = painterResourceId),
        contentDescription = null
    )
}

@Composable
fun SignInWithEmailButton(emailLoginClick: () -> Unit) {
    OutlinedButton(
        onClick = { emailLoginClick() },
        modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.fui_bgEmail),
            contentColor =  colorResource(id = R.color.white)
        )
    ) {
        SignInButtonRow(iconId = R.drawable.ic_baseline_email_24, buttonTextId = R.string.sign_in_with_email)
    }
}

@Composable
fun SignInButtonRow(@DrawableRes iconId: Int, @StringRes buttonTextId: Int) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp)
    ) {
        LoginButtonIcon(iconId)
        LoginButtonText(buttonTextId)
    }
}
@Composable
fun LoginButtonIcon(@DrawableRes painterResourceId: Int) {
    Icon(
        tint = Color.Unspecified,
        painter = painterResource(painterResourceId),
        contentDescription = null
    )
}
@Composable
fun LoginButtonText(@StringRes stringResourceId: Int) {
    Text(
        text = stringResource(stringResourceId),
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.button,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
    )
}



//
//@Composable
//fun RegisterScreen(
//    LoginViewModel: LoginViewModel? = null,
//    onNavToHomePage:() -> Unit,
//    onNavToLoginPage:() -> Unit,
//) {
//    val loginUiState = LoginViewModel?.loginUiState
//    val isError = loginUiState?.signUpError != null
//    val context = LocalContext.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Text(
//            text = "Sign Up",
//            style = MaterialTheme.typography.h3,
//            fontWeight = FontWeight.Black,
//            color = MaterialTheme.colors.primary
//        )
//        if (isError){
//            Text(text = loginUiState?.signUpError ?: "unknown error", color = Color.Red)
//        }
//
//        OutlinedTextField(
//            value = loginUiState?.userNameSignUp ?: "",
//            onValueChange = {LoginViewModel?.onUserNameChangeSignup(it)},
//            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null,)},
//            label = {
//                Text(text = "Email")
//            },
//            isError = isError
//        )
//
//        OutlinedTextField(
//            value = loginUiState?.passwordSignUp ?: "",
//            onValueChange = {LoginViewModel?.onPasswordChangeSignup(it)},
//            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null)},
//            label = {
//                Text(text = "Password")
//            },
//            visualTransformation = PasswordVisualTransformation(),
//            isError = isError
//            )
//
//        OutlinedTextField(
//            value = loginUiState?.confirmPasswordSignUp ?: "",
//            onValueChange = {LoginViewModel?.onConfirmPasswordChange(it)},
//            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null)},
//            label = {
//                Text(text = "Confirm Password")
//            },
//            visualTransformation = PasswordVisualTransformation(),
//            isError = isError
//        )
//
//
//        Button(onClick = { LoginViewModel?.createUser(context) }) {
//            Text(text = "Sign Up")
//        }
//        Spacer(modifier = Modifier.size((16.dp)))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center,
//        ) {
//            Text(text = "Already Have An Account?")
//            Spacer(modifier = Modifier.size(8.dp))
//            TextButton(onClick = { onNavToLoginPage.invoke() }) {
//                Text(text = "Login")
//            }
//        }
//
//        if (loginUiState?.isLoading == true) {
//            CircularProgressIndicator()
//        }
//
//        LaunchedEffect(key1 = LoginViewModel?.hasUser){
//            if (LoginViewModel?.hasUser == true){
//                onNavToHomePage.invoke()
//            }
//        }
//
//    }
//
//
//}
//
//
//@Preview(showSystemUi = true)
//@Composable
//fun PrevLoginScreen() {
//    CiChatTheme() {
//        LoginScreen(onNavToHomePage = { /*TODO*/ }) {
//
//        }
//    }
//}
//
//@Preview(showSystemUi = true)
//@Composable
//fun PrevSignupScreen() {
//    CiChatTheme() {
//        RegisterScreen(onNavToHomePage = { /*TODO*/ }) {
//
//        }
//    }
//}
