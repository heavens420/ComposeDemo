package com.zlx.compose.ui.screens

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.zlx.compose.ui.components.NavigationBackScreen


/**
 * 带滚动的TabRow 其他同TabRow
 */
@Composable
fun ScrollableTabRowScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    val selected by remember {
        mutableIntStateOf(0)
    }
    ScrollableTabRow(selectedTabIndex = selected) {

    }
}