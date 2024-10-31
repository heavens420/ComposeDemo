package com.zlx.compose.ui.screens;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zlx.compose.ui.components.NavigationBackScreen


@Composable
fun NavigationScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home") {
            NavigationHomeSample() {
                navController.navigate("Second")
            }
        }
        composable(route = "Second") {
            NavigationSecondPageSample() {
                navController.navigate("Third")
            }
        }
        composable(route = "Third") {
            NavigationThirdPageSample() {
                navController.popBackStack("Home", inclusive = false)
            }
        }
    }
}

@Composable
fun NavigationHomeSample(goSecondPage: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home Page",
            color = Color.White,
            modifier = Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Button(onClick = {
            goSecondPage()
//            navHostController.popBackStack("Home",inclusive = false)
//            navHostController.popBackStack()
        }) {
            Text(text = "Go Second Page", color = Color.LightGray)
        }
    }
}

@Composable
fun NavigationSecondPageSample(goThirdPage: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Second Page",
            color = Color.Blue,
            modifier = Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Button(onClick = {
            goThirdPage()
        }) {
            Text(text = "Go to Home Page", color = Color.Yellow)
        }
    }
}

@Composable
fun NavigationThirdPageSample(goHomePage: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Third Page",
            color = Color.Blue,
            modifier = Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Button(onClick = {
            goHomePage()
        }) {
            Text(text = "Go to Home Page", color = Color.Yellow)
        }
    }
}
