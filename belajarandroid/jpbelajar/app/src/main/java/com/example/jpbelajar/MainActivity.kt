package com.example.jpbelajar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ComposableButton(text = "Ini Button 1", Color.Blue)
                    val checkboxState = remember {
                        mutableStateOf(false)
                    }
                    CustomeCheckBox(title = "chekbox", checkboxState = checkboxState.value) {
                        checkboxState.value = !checkboxState.value
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ComposableButton(text = "Ini Button 2", Color.Red)
                    val painter = painterResource(id = R.drawable.tugas)
                    val description = "Tugas Sma Ndak Mari"
                    val title = "Tugas MTK"
                    Box(modifier = Modifier
                        .fillMaxWidth(0.2f)
                        .padding(16.dp)
                    )
                    ImageCard(
                        painter = painter,
                        contentDescription = description,
                        title = title)
                }

                    Column(
                        modifier = Modifier
                            .border(width = 2.dp, Color.Black)
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(MaterialTheme.colors.primary),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Column() {
                                Text(
                                    text = "Ayam",
                                    modifier = Modifier
                                        .padding(horizontal = 20.dp)
                                )
                                Text(
                                    text = "tepi",
                                    modifier = Modifier
                                        .padding(horizontal = 20.dp )
                                )
                            }

                            OutlinedButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(end = 20.dp),
                            ) {
                                Text(text = "abcd")
                        }
                    }


                }
                Spacer(modifier = (Modifier.padding(19.dp)))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 2.dp, Color.Gray)

                        .height(100.dp)
                        .background(MaterialTheme.colors.secondary),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                        .padding(20.dp)) {
                        Text(
                            text = "JetPack",
                        )
                        Text(text = "uwu")
                    }  
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(end = 20.dp)
                    ) {
                        Text(text = "acsdto ")
                    }
                    }
                Spacer(modifier = (Modifier.padding(19.dp)))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1f)
                        .background(color = Color.Red)
                        .padding(top = 5.dp)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
//                                .padding(10.dp)
                                .border(2.dp, color = Color.Black)
                                .background(color = Color.Blue)
                                .padding(25.dp)
                        ){

                        }
                        Box(
                            modifier = Modifier
//                                .padding(10.dp)
                                .border(2.dp, color = Color.Black)
                                .background(color = Color.Blue)
                                .clip(CircleShape)
                                .background(color = Color.Black)
                                .padding(25.dp)
                        ){

                        }
                        Box(
                            modifier = Modifier
//                                .padding(10.dp)
                                .border(2.dp, color = Color.Black)
                                .background(color = Color.Blue)
                                .padding(25.dp)
                        ){

                        }

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                        modifier = Modifier
//                                .padding(10.dp)
                            .border(2.dp, color = Color.Black)
                            .background(color = Color.Blue)
                            .padding(25.dp)
                        ){

                        }
                        Box(
                        modifier = Modifier
//                                .padding(10.dp)
                            .border(2.dp, color = Color.Black)
                            .background(color = Color.Blue)
                            .padding(25.dp)
                        ){

                        }
                    }

                }
                }
                

            }

        }
    }

//@Preview
@Composable
fun ComposableButton(text : String, color : Color) {
   Button(
       onClick = { /*TODO*/ },
       modifier = Modifier
//           .fillMaxSize()
           .padding(10.dp)
           .clip(RoundedCornerShape(17.dp)),
       colors = ButtonDefaults.buttonColors(backgroundColor = color)
       ) {
       Text(text = text, color = Color.Black)

   } 
}

@Composable
fun CustomeCheckBox(title: String, checkboxState: Boolean, onCheckboxProcess: ((Boolean) -> Unit)?) {
    Row(
        modifier = Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkboxState,
            onCheckedChange = onCheckboxProcess,
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = title)
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
    ) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter, 
                contentDescription = contentDescription, 
                contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 300f
                )
                )
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomStart) {
                Text(text = title , style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }


    }
}
