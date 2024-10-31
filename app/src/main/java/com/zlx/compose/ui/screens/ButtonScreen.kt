package com.zlx.compose.ui.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zlx.compose.ui.components.NavigationBackScreen

/**
 * 按钮
 */
@Composable
fun ButtonScreen(canNavigateBack: Boolean, onClickBack: () -> Unit) {
//    if (canNavigateBack) {
//        IconButton(onClick = { onClickBack() }) {
//            Icon(
//                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
//                contentDescription = "Back"
//            )
//        }
//    }
    NavigationBackScreen(canNavigateBack = canNavigateBack) {
        onClickBack()
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { Log.d("=======", "button 被点击了") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Red
            ),
            border = BorderStroke(1.dp, Color.Red)
        ) {
            Text(text = "This is a button")
        }

        TextButton(onClick = {
            Log.d("TextButton", "点击了again")
        }) {
            Text(text = "This another button")
        }

        OutlinedButton(onClick = {
            Log.d("OutlinedButton", "点击了again")
        }) {
            Text(text = "This another button  OutlinedButton")
        }

        IconButton(
            onClick = {
                Log.d("ButtonSample", "click the button")
            },
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = null)
        }
    }
}
