package com.zlx.compose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zlx.compose.ui.components.NavigationBackScreen

@Composable
fun LazyHorizontalGridScreen(canNavigateBack:Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    val data = remember {
        mutableStateListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }
    Column {
        Button(
            onClick = {
//            data.add(Random.nextInt(11, 999))
                data.add(434)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "新增数据")
        }
        // Fixed() 设置显示几行
        LazyHorizontalGrid(rows = GridCells.Fixed(3)) {
            items(data) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.padding(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null,
                        modifier = Modifier.size(70.dp)
                    )
                    // 这里设置字体大小sp 用dp会报错
                    Text(text = "NO.$it", fontSize = 17.sp)
                }
            }
        }
    }

}
