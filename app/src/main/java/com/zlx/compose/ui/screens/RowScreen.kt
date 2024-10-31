package com.zlx.compose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zlx.compose.ui.components.NavigationBackScreen


/**
 * 布局容器 row
 */
@Composable
fun RowScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    Row(
        Modifier
            .size(700.dp, 100.dp)
            .background(Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "First", Modifier.background(Color.Yellow))
        Text(text = "Second", Modifier.background(Color.Green))
        Text(text = "Third", modifier = Modifier.background(Color.Black), color = Color.White)
    }
}