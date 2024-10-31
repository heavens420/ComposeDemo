package com.zlx.compose.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zlx.compose.ui.components.NavigationBackScreen


/**
 * Surface和Card相似 Surface更为基础 Card自带一些样式
 */
@Composable
fun SurfaceScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    // shape : RectangleShape、CircleShape、RoundedCornerShape、CutCornerShape
    Surface(
        modifier = Modifier.size(300.dp, 100.dp),
        shape = RoundedCornerShape(10.dp),
        color = Color.Cyan,
        border = BorderStroke(
            1.dp,
            Color.Yellow
        ),
        shadowElevation = 10.dp,
        tonalElevation = 10.dp
    ) {
        com.zlx.compose.demo.ImageSample()
    }
}
