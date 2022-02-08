package com.webkeyz.jetpackcompose

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.animation.AnimationUtils.lerp
import com.webkeyz.jetpackcompose.ui.theme.JetpackComposeTheme
import com.webkeyz.jetpackcompose.ui.theme.Purple500

class MainActivity : ComponentActivity() {




    @ExperimentalTransitionApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewText()

        }
    }
}

@ExperimentalTransitionApi
@Composable
fun NewText() {
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
        button()
    }
}

@ExperimentalTransitionApi
@Preview
@Composable
fun DefaultPreview() {
    NewText()
}

@Composable
fun button(){
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
    )
}
@Composable
fun Image(){
    Image(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.5f)
            ,
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

@SuppressLint("RestrictedApi")
@Composable
private fun JetsnackBottomNavLayout(
    selectedIndex: Int,
    itemCount: Int,
    animSpec: AnimationSpec<Float>,
    indicator: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // Track how "selected" each item is [0, 1]
    val selectionFractions = remember(itemCount) {
        List(itemCount) { i ->
            Animatable(if (i == selectedIndex) 1f else 0f)
        }
    }
    selectionFractions.forEachIndexed { index, selectionFraction ->
        val target = if (index == selectedIndex) 1f else 0f
        LaunchedEffect(target, animSpec) {
            selectionFraction.animateTo(target, animSpec)
        }
    }

    // Animate the position of the indicator
    val indicatorIndex = remember { Animatable(0f) }
    val targetIndicatorIndex = selectedIndex.toFloat()
    LaunchedEffect(targetIndicatorIndex) {
        indicatorIndex.animateTo(targetIndicatorIndex, animSpec)
    }

    Layout(
        modifier = modifier.height(56.dp),
        content = {
            content()
            Box(Modifier.layoutId("indicator"), content = indicator)
        }
    ) { measurables, constraints ->
        check(itemCount == (measurables.size - 1)) // account for indicator

        // Divide the width into n+1 slots and give the selected item 2 slots
        val unselectedWidth = constraints.maxWidth / (itemCount + 1)
        val selectedWidth = 2 * unselectedWidth
        val indicatorMeasurable = measurables.first { it.layoutId == "indicator" }

        val itemPlaceables = measurables
            .filterNot { it == indicatorMeasurable }
            .mapIndexed { index, measurable ->
                // Animate item's width based upon the selection amount
                val width = lerp(unselectedWidth, selectedWidth, selectionFractions[index].value)
                measurable.measure(
                    constraints.copy(
                        minWidth = width,
                        maxWidth = width
                    )
                )
            }
        val indicatorPlaceable = indicatorMeasurable.measure(
            constraints.copy(
                minWidth = selectedWidth,
                maxWidth = selectedWidth
            )
        )

        layout(
            width = constraints.maxWidth,
            height = itemPlaceables.maxByOrNull { it.height }?.height ?: 0
        ) {
            val indicatorLeft = indicatorIndex.value * unselectedWidth
            indicatorPlaceable.placeRelative(x = indicatorLeft.toInt(), y = 0)
            var x = 0
            itemPlaceables.forEach { placeable ->
                placeable.placeRelative(x = x, y = 0)
                x += placeable.width
            }
        }
    }
}




