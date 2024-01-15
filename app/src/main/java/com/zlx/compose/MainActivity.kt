package com.zlx.compose

import MyApp
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zlx.compose.demo.ComposeSample
import com.zlx.compose.demo.MySootheAppLandscape
import com.zlx.compose.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 使用Material design样式
            ComposeDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}

@Composable
fun TestText() {
    Text(text = "first line")
    Text(text = "second line")
}

/**
 * 使组件 在同一列显示 列是相对的列
 */
@Composable
fun TestColumn(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        ClickableText(
            buildAnnotatedString {
                append("this is another line : $name")
            },
            onClick = { offset ->
                Log.d("offset", "offset:$offset")
            }
        )
    }
}

/**
 * 使组件 在同一行显示 这里的一行是指相对的一行
 */
@Composable
fun TestRow(name: String, modifier: Modifier = Modifier) {
    Row {
        Column {
            Text(text = "ni hao a ", modifier = modifier)
        }
        Column {
            Text(text = "zhe shi jie $name", modifier = modifier)
        }
        TestColumn(name = "android")
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

@Composable
fun TestList(messages: List<Message>) {
    // 使得列表滚动
    val state = rememberLazyListState()

    LazyColumn(state = state) {
        items(messages) { msg -> TestImageAndText(message = msg) }
//        items(messages) {
//            TestRow(name = "", Modifier.clickable(onClickLabel = "123") {
//            Log.d("column","clicked!")
//        }) }
    }
}


@Preview(
    showBackground = true, name = "night mode", uiMode = Configuration.UI_MODE_NIGHT_YES,
    locale = "zh-rCN"
)
@Composable
fun GreetingPreview() {

    ComposeDemoTheme {
//        TestList(messages = SampleData.conversationSample)
//        ComposeSample()
//        MySootheAppLandscape()
        MyApp()

    }
}

data class Message(
    val author: String,
    val body: String
)

// 列表数据
object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Colleague",
            "Test...Test...Test..."
        ),
        Message(
            "Colleague",
            "List of Android versions:\n" +
                    "Android KitKat (API 19)\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n"
        ),
        Message(
            "Colleague",
            "I think Kotlin is my favorite programming language.\n" +
                    "It's so much fun!"
        ),
        Message(
            "Colleague",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ),
        Message(
            "Colleague",
            "It's available from API 21+ :)"
        ),
        Message(
            "Colleague",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Colleague",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Colleague",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Colleague",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Colleague",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Colleague",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        Message(
            "Colleague",
            "This is another line?"
        ),
        Message(
            "Colleague",
            "How do you know your name?"
        ),
        Message(
            "Colleague",
            "Do you like playing games?"
        ),
        Message(
            "Colleague",
            "You looks funny?"
        ),
        Message(
            "Colleague",
            "This is the world?"
        ),


        )
}