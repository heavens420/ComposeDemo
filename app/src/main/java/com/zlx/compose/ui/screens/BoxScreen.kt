package com.zlx.compose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zlx.compose.ui.components.NavigationBackScreen


/**
 * 布局容器 Box
 * 不提供任何样式
 */
@Composable
fun BoxScreen(canNavigateBack: Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    Box(Modifier.fillMaxSize().background(Color.Magenta)) {
        Divider(thickness = 5.dp, color = Color.Yellow)
        Box(
            Modifier
                .fillMaxSize()
                .border(width = 5.dp, color = Color.Cyan)
//                .background(Color.Cyan)
        ) {
            Text(text = "111111111", modifier = Modifier.align(Alignment.Center))
        }
        Box(
            Modifier
                .matchParentSize()
                .padding(top = 50.dp, bottom = 20.dp)
                .border(width = 5.dp, color = Color.Yellow)
//                .background(Color.Yellow)
        ) {
            Text(text = "22222222222222", modifier = Modifier.align(Alignment.Center))
        }
        Box(
            Modifier
                .matchParentSize()
                .padding(40.dp)
                .border(width = 5.dp, color = Color.Magenta)
//                .background(Color.Magenta)
        ) {
            Text(text = "3333333333333333")
        }
        Box(
            Modifier
                .align(Alignment.Center)
                .size(100.dp, 300.dp)
                .border(width = 5.dp, color = Color.Green)
//                .background(Color.Green)
        ) {
            Text(text = "44444444444", modifier = Modifier.align(Alignment.Center))
        }
        Box(
            Modifier
                .align(Alignment.TopStart)
                .size(150.dp, 150.dp)
                .border(width = 5.dp, color = Color.Red)
//                .background(Color.Red)
        ) {
            Text(text = "5555555555")
        }
        Box(
            Modifier
                .align(Alignment.BottomEnd)
                .size(150.dp, 150.dp)
                .background(Color.Transparent)
                .border(width = 5.dp, color = Color.Blue)
        ) {
            Text(text = "6666666666")
        }
    }
}
