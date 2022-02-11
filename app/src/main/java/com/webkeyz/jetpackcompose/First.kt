package com.webkeyz.jetpackcompose

import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.webkeyz.jetpackcompose.ui.theme.Purple500

@Composable
fun FirstSCreen( navController : NavController){
    Column( horizontalAlignment = Alignment.CenterHorizontally , modifier = Modifier.background(
        Color.White)) {
        Image()
        Text(text = "fdfd" , style = TextStyle(color = Color.Black , fontStyle = FontStyle.Italic , fontSize = 25.sp))
        Text("First Line",style = TextStyle(color = Color.Green))
        Text("Second Line",style = TextStyle(color = Color.Red,fontStyle = FontStyle.Italic))

        Row() {
            Text("3th Line",style = TextStyle(color = Color.Green) , modifier = Modifier
                .padding(end =  10.dp))
            Text("Second Line",style = TextStyle(color = Color.Blue,fontStyle = FontStyle.Italic))
        }
        TextFild()
        val shape = CircleShape
        Text(
            text = "Text 1",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(2.dp, MaterialTheme.colors.secondary, shape)
                .background(MaterialTheme.colors.primary, shape)
                .padding(16.dp)
                .clickable { navController.navigate("register_page") }
                .onFocusChanged { Modifier.background(Color.Green) }

        )    }

}

@Composable
fun ComposeTest() {

}

@ExperimentalTransitionApi
@Preview
@Composable
fun DefaultPreview() {
    ComposeTest()
}

//@Composable
//fun button(){
//    val shape = CircleShape
//    Text(
//        text = "Text 1",
//        style = TextStyle(
//            color = Color.White,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Center),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .border(2.dp, MaterialTheme.colors.secondary, shape)
//            .background(MaterialTheme.colors.primary, shape)
//            .padding(16.dp)
//            .clickable { navController.navigate("register_page") }
//    )
//}
@Composable
fun Image(){
    androidx.compose.foundation.Image(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.5f),
        painter = painterResource(R.drawable.login),
        contentDescription = "Login Image",
        contentScale = ContentScale.Fit,
    )
}

@Composable
fun TextFild(){
    val emailVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val passwordVisiblity = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = emailVal.value,
        onValueChange = { emailVal.value = it },
        label = { Text(text = "Email Address", color = Color.Black) },
        placeholder = { Text(text = "Email Address", color = Color.Black) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(.9f),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black, textColor = Color.Black ,
            focusedLabelColor = Color.Green , focusedBorderColor = Color.Green
        )
    )

    Spacer(modifier = Modifier.padding(20.dp))

    OutlinedTextField(
        value = passwordVal.value,
        onValueChange = { passwordVal.value = it },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black, textColor = Color.Black
        ),
        trailingIcon = {
            IconButton(onClick = {
                passwordVisiblity.value = !passwordVisiblity.value
            }) {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                    contentDescription = "Password",
                    tint = if (passwordVisiblity.value) Purple500 else Color.Gray
                )
            }
        },
        label = { Text(text = "Password", color = Color.Black) },
        placeholder = { Text(text = "Password", color = Color.Black) },
        singleLine = true,
        visualTransformation = if (passwordVisiblity.value) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth(0.9f)
    )

}
