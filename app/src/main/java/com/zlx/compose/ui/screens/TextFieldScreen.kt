package com.zlx.compose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.zlx.compose.ui.components.NavigationBackScreen


/**
 * 文本框
 *
 * enabled 是否启用禁用，无法聚集，不可编辑，无法复制
 * readOnly 是否只读，不可编辑，可复制
 * textStyle 设置文本样式
 * lable 显示在输入框边框的文本（可选）
 * placeHolder 未输入状态下提示文字
 * leadingIcon 显示在输入框左侧的图标
 * trailingIcon 显示在输入框右侧的图标
 * keyboradOptions 键盘类型，如数字键盘
 * keyboradActions 功能键事件监听
 * singleLine 是否单行显示，如果设置为 true，则忽略maxLines
 * maxLines 大于等于1
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    var name by remember {
        mutableStateOf("")
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("name")
            },
            placeholder = {
                Text(text = "pls input name")
            },

            // 输入框左侧图标
            leadingIcon = {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
            },
            // 键盘按键监听
            keyboardActions = KeyboardActions(onDone = {

            }),
            // 键盘类型
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .background(
                    Color.Cyan
                ).fillMaxWidth().height(50.dp),
            maxLines = 5
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Account") })
    }

}
