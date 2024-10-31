package com.zlx.compose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zlx.compose.R
import com.zlx.compose.ui.components.NavigationBackScreen

/**
 * 布局容器 LazyRow: 懒加载row 只会初始化屏幕内的row 超出屏幕外的自动销毁 节省资源
 * ListItem: 通常配合LazyRow和LazyColumn使用 自动根据父容器创建对应的row或者column 除了自带一些样式功能之外并无其他作用
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyRowScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    val state = rememberLazyListState()
    val state2 = rememberLazyListState()
    val items = listOf(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 6",
        "Item 7",
        "Item 8",
        "Item 9",
        "Item 10"
    )

    Column {
        LazyRow(state = state) {
            items(items.size) {
                Row {
                    Text(text = "==${items[it]}==")
                    Spacer(modifier = Modifier.width(100.dp))
                }
            }
        }
    }

    // ListItem
    Column {
        LazyRow(state = state2) {
            items(items.size) {
                ListItem(
                    headlineContent = {
                        Text(
                            text = "123",
                            Modifier
                                .background(Color.Red)
                                .size(10.dp)
                        )
                    },
                    // 主题内容上方显示的内容
                    overlineContent = { Text(text = "显示在主题内容上方") },
                    // 主题内容
                    leadingContent = { Text(text = items[it], Modifier.background(Color.Green)) },
                    // 尾部追加内容
                    trailingContent = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null
                        )
                    },
                )
            }
        }
    }

}
