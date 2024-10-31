package com.zlx.compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.zlx.compose.R
import com.zlx.compose.ui.components.NavigationBackScreen

/**
 * 文本
 */
@Composable
fun TextScreen(canNavigateBack:Boolean, onClickBack: () -> Unit ) {
//    Column(Modifier.padding(vertical = 10.dp, horizontal = 5.dp)) {
//        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back",Modifier.clickable { onClickBack() } )
//    }
    NavigationBackScreen(canNavigateBack, onClickBack)

    if (canNavigateBack) {
        IconButton(onClick = onClickBack) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back"
            )
        }
    }
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = "This is a text")
        Text(
            // 从资源文件读取
            text = stringResource(id = R.string.app_name),
            color = Color.Blue,
            fontSize = 17.sp,
            fontStyle = FontStyle.Italic
//            fontSize = TextUnit(
//                16f,
//                TextUnitType.Sp
//            )
        )
        // 一行文本 多种样式
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(Color.Red)) {
                    append("锄禾日当午，")
                }
                withStyle(style = SpanStyle(Color.Green)) {
                    append("汗滴禾下土。")
                }
                withStyle(style = SpanStyle(Color.Blue)) {
                    append("谁知盘中餐，")
                }
                withStyle(style = SpanStyle(Color.Yellow)) {
                    append("粒粒皆辛苦")
                }
            }
        )
    }
}
