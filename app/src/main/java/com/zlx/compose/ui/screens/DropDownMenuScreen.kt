package com.zlx.compose.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.zlx.compose.ui.components.NavigationBackScreen


@Composable
fun DropDownMenuScreen(canNavigateBack: Boolean, onClickBack:() -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    var expanded by remember {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    expanded = true
                }
//                .height(200.dp)
        )
        DropdownMenu(
            expanded = expanded, onDismissRequest = {
                Log.d(
                    "=========onDismissRequest============",
                    "收起时调用，current value: $expanded"
                )
                expanded = false
            },
            // 下拉框位置偏移量
//            offset = DpOffset(10.dp, 1600.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                // 安全级别 是否可以截屏
                securePolicy = SecureFlagPolicy.SecureOn
            )
        ) {
            DropdownMenuItem(
                text = { Text(text = "item 1") },
                onClick = { expanded = false },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null
                    )
                })
            DropdownMenuItem(
                text = { Text(text = "item 2") },
                onClick = { expanded = false },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = null
                    )
                })
            DropdownMenuItem(
                text = { Text(text = "item 3") },
                onClick = { expanded = false },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Call,
                        contentDescription = null
                    )
                })
            DropdownMenuItem(
                text = { Text(text = "item 4") },
                onClick = { expanded = false },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Build,
                        contentDescription = null
                    )
                })
        }
    }
}
