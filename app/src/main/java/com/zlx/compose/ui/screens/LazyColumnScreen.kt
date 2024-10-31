package com.zlx.compose.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zlx.compose.R
import com.zlx.compose.data.Message
import com.zlx.compose.data.RowData
import com.zlx.compose.ui.components.NavigationBackScreen


@Composable
fun LazyColumnScreen(canNavigateBack: Boolean, onClickBack: () -> Unit) {
    NavigationBackScreen(canNavigateBack,onClickBack)

    // 使得列表滚动
    val state = rememberLazyListState()

    val messages = RowData.conversationSample
    LazyColumn(state = state) {
        items(messages) { msg -> TestImageAndText(message = msg) }
//        items(messages) {
//            TestRow(name = "", Modifier.clickable(onClickLabel = "123") {
//            Log.d("column","clicked!")
//        }) }
    }
}


@Composable
fun TestImageAndText(message: Message) {
    Row(modifier = Modifier.padding(all = 0.8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Concat profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.onSecondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // 记录列表是否展开
        var isExpand by remember { mutableStateOf(false) }

        val surfaceColor by animateColorAsState(
            targetValue = if (isExpand) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            label = "1233333"
        )

        Column(modifier = Modifier.clickable { isExpand = !isExpand }) {
            Text(
                text = message.author,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.width(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
//                tonalElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = message.body,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(4.dp),
                    maxLines = if (isExpand) Int.MAX_VALUE else 1,
                )
            }
        }
    }
}
