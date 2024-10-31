package com.zlx.compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.zlx.compose.ui.components.NavigationBackScreen


@Composable
fun AlertDialogScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    var showDialog by remember {
        mutableStateOf(false)
    }
    NavigationBackScreen(canNavigateBack,onClickBack)

//    Column(Modifier.padding(vertical = 10.dp, horizontal = 5.dp)) {
//        Icon(
//            imageVector = Icons.AutoMirrored.Sharp.KeyboardArrowLeft,
//            contentDescription = "Back",
//            Modifier.clickable { onClickBack() },
//        )
//    }

    if (canNavigateBack) {
        IconButton(onClick = { onClickBack() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back"
            )
        }
    }
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showDialog = true }) {
            Text(text = "AlertDialog")
        }
        if (showDialog) {
            AlertDialog(
                // 点击弹窗外部分执行的操作 如不想有任何操作 参数内容设置为空
//                onDismissRequest = { },
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(text = "确认")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(text = "取消")
                    }
                },
                title = {
                    Text(text = "AlertDialogSample")
                },
                text = {
                    Text(
                        text = "This is AlertDialogSample \n" +
                                "Nothing to do here"
                    )
                })
        }
    }
}

