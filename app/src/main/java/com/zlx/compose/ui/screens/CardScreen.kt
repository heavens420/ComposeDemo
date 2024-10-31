package com.zlx.compose.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zlx.compose.ui.components.NavigationBackScreen

/**
 * 布局容器Card
 * 提供卡片一样的样式
 */
@Composable
fun CardScreen(canNavigateBack: Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    Card(
        modifier = Modifier.padding(5.dp),
        colors = CardDefaults.cardColors(Color.LightGray),
        shape = CardDefaults.outlinedShape,
        border = BorderStroke(1.dp, Color.Red),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Divider(thickness = 3.dp, color = Color.Yellow)
        Text(
            text = "This is a card",
            modifier = Modifier
                .padding(10.dp),
            color = Color.Green
        )
    }
}
