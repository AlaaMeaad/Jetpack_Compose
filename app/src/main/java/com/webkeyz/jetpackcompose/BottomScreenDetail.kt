package com.webkeyz.jetpackcompose

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BottomHome() {
//    Column(
//        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "Home Screen",
//            style = MaterialTheme.typography.h5,
//            color = Color.White,
//            fontWeight = FontWeight.Bold
//        )
//    }

    val scroll = rememberScrollState(0)


    val state = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        androidx.compose.foundation.Image(
            painter = painterResource(R.drawable.register_img),
            contentDescription = "Register Image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .fillMaxHeight(0.4f),
            contentScale = ContentScale.Fit
        )

        Text(
            text = "Paragraph on Technology: Technology is something that is gaining increasing importance in the world today. Wherever you look, there is technology. Even the device you are using to read this article uses technology. In simple words, technology is when we use science to apply it for practical purposes.\n" +
                    "\n" +
                    "For example, in a mobile phone, which is a form of technology, we are taking the practical purpose of communication and mixing it with science to create a phone. Here are some paragraphs on technology for children and students."
            , color = Color.Gray , fontSize = 32.sp , modifier = Modifier.padding(start = 5.dp , end = 5.dp)
                .verticalScroll(scroll)
        )


    }
}


@Composable
fun BottomFavourite() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home Favourite",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun BottomSearch() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home Search",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun BottomUser() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home User",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun BottomSetting() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home Setting",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

