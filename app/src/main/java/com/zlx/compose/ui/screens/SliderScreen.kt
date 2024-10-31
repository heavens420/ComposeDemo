package com.zlx.compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.zlx.compose.ui.components.NavigationBackScreen


/**
 * 滑动条
 *
 * value 当前值
 * valueRange 可选值的范围，默认是0f~1f
 * steps 步频
 */
@Composable
fun SliderScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    var value by remember {
        mutableFloatStateOf(30f)
    }
    var rangeValue by remember {
        mutableStateOf(20f..50f)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(value = value, onValueChange = { value = it }, valueRange = 0f..60f)
        Slider(value = value, onValueChange = { value = it }, valueRange = 0f..100f, steps = 10)
        RangeSlider(
            value = rangeValue,
            onValueChange = { rangeValue = it },
            valueRange = 0f..70f,
            steps = 5
        )
    }
}
