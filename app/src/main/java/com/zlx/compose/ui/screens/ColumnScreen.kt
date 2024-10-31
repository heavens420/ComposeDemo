package com.zlx.compose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zlx.compose.ui.components.NavigationBackScreen

/**
 * 布局容器 列
 */
@Composable
fun ColumnScreen(canNavigateBack: Boolean,onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Create a Text with the text "First Text"
        Text(text = "First Text")
        // Create a Text with the text "Second Text"
        Text(text = "Second Text")
    }
}
