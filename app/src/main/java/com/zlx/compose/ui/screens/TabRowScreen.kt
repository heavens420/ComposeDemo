package com.zlx.compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zlx.compose.ui.components.NavigationBackScreen

@Composable
fun TabRowScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    var selected by remember {
        mutableIntStateOf(0)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            selectedTabIndex = selected,
            containerColor = Color.Gray
        ) {
            LeadingIconTab(
                selected = selected == 0,
                onClick = { selected = 0 },
                text = { Text(text = "tab0") },
                icon = { Icon(imageVector = Icons.Default.Star, contentDescription = null) },
                selectedContentColor = Color.Blue
            )
            Tab(
                selected = selected == 1,
                onClick = { selected = 1 },
                selectedContentColor = Color.Red
            ) {
                Text(text = "tab1")
            }
            Tab(
                selected = selected == 2,
                onClick = { selected = 2 },
                selectedContentColor = Color.Yellow
            ) {
                Text(text = "tab2")
            }
        }
        Text(text = "current Index: $selected", Modifier.padding(10.dp))
    }
}
