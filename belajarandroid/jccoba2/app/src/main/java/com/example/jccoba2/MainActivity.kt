package com.example.jccoba2

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jccoba2.ui.theme.Jccoba2Theme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Jccoba2Theme {
                    // A surface container using the 'background' color from the theme
                    MyApp()

//                CustomButton(Color.Green)
                }
                Textbox(name = "Aku Cinta Kristina Wati")

            }


        }
    }
}

@Composable
fun MyApp(names: List<String> = listOf("World", "Compose")) {
    Column() {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {
    val expanded = remember {
        mutableStateOf(false)
    }

    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        color = MaterialTheme.colorScheme.primary
        ) {
        Row(modifier = Modifier.padding(25.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
//                .clip(RoundedCornerShape(20.dp))
            ) {

                Text (text = "Hello,")
                Text(text = name)
            }
            val shape = CircleShape
            OutlinedButton(
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
//                color = MaterialTheme.colorScheme.background,

                onClick = { expanded.value = !expanded.value },
                modifier = Modifier
                    .border(2.dp, Color.Black, shape)
                    .background(Color.Green, shape),
                        ) {
                Text(if (expanded.value)"Show Less" else "Show More ")
            }
        }


    }
}

@Composable
fun Textbox(name: String) {
    val colorUpdate = remember {
        mutableStateOf(Color.Gray)
    }
    Box(
        modifier = Modifier
            .padding(10.dp)
            .background(color = colorUpdate.value)
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .clip(RoundedCornerShape(5.dp))

    ) {
        val fontFamily = FontFamily(
            Font(R.font.nunitosans_bolditalic, FontWeight.Thin),
            Font(R.font.nunitosans_bold, FontWeight.Light)// thin jika bertemu thin bakal crash
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontSize = 50.sp
                    )
                ) {
                    append(name[0])
                }
                append(name.drop(1))
            },
            modifier = Modifier.padding(20.dp),
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.LineThrough
            )

    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .background(Color.Red)
            .padding(50.dp)
            .clickable { colorUpdate.value = Color.Red}
        ) {

        }
        Box(modifier = Modifier
            .background(Color.Blue)
            .padding(50.dp)
            .clickable { colorUpdate.value = Color.Blue }
        ) {

        }
        Box(modifier = Modifier
            .background(Color.Yellow)
            .padding(50.dp)
            .clickable { colorUpdate.value = Color.Yellow }
        ) {

        }
    }
}



//@Composable
//private fun MyApp() {
//    Surface(color = MaterialTheme.colorScheme.background) {
//        Greeting("Compose")
//    }
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jccoba2Theme {
        Greeting("Android")
    }
}

@Preview(name = "tor", showBackground = true , widthDp = 320)
@Composable
private fun MyAppPreview() {
    Jccoba2Theme() {
        MyApp()
    }
}

//@Preview(name = "Textbox", widthDp = 480, heightDp = 480)
//@Composable
//fun PreviewTextbox() {
//    Textbox(name = "Boxkie Boxie")
//}