package com.zlx.compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.zlx.compose.ui.components.NavigationBackScreen


@Composable
fun DialogScreen(canNavigateBack: Boolean, onClickBack:() -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    var showDialog by remember {
        mutableStateOf(false)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showDialog = !showDialog }) {
            Text(text = "打开弹窗")
        }
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = !showDialog }) {
                com.zlx.compose.demo.BoxSample()
            }
        }
    }

}
