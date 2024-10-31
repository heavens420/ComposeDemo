package com.zlx.compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zlx.compose.ui.components.NavigationBackScreen


/**
 * 进度条
 */
@Composable
fun ProcessScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Blue, strokeWidth = 10.dp)

        CircularProgressIndicator(
            progress = { 0.6f },
        )

        LinearProgressIndicator(color = Color.Cyan, trackColor = Color.LightGray)


    }
}
