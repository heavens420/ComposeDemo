package com.zlx.compose.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zlx.compose.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen() {
//状态
//    val scaffoldState = rememberScaffoldState()
    val drawState = rememberDrawerState(initialValue = DrawerValue.Open)
    val snackbarHostState  = remember {
        SnackbarHostState()
    }

//协程的作用域
    val scope = rememberCoroutineScope()
//当前选择的NavItem
    var selectIndex by remember { mutableIntStateOf(0) }
    val navTextList = listOf("主页", "发现", "我的")
    val imageList = listOf(R.drawable.ab1_inversions, R.drawable.ab2_quick_yoga, R.drawable.ab5_hiit)

//图标
    val iconList = listOf(Icons.Default.Home, Icons.Default.Favorite, Icons.Default.AccountBox)
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState ) },
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            //使用协程
                            scope.launch {
                                //改变状态,显示drawer抽屉
                                drawState.open()
                            }
                        }
                    ) {
                        Icon(Icons.Filled.Menu, null)
                    }
                },
                title = {
                    Text("测试标题")
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(Icons.Filled.Share, null)
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(Icons.Filled.Settings, null)
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        bottomBar = {
            BottomAppBar {
                navTextList.forEachIndexed { index, str ->
                    NavigationBarItem(
                        label = { Text(str) },
                        selected = index == selectIndex,
                        onClick = {
                            selectIndex = index
                            Log.d("==============", "$selectIndex")
                        },
                        icon = {
                            Icon(
                                imageVector = iconList[index],
                                contentDescription = null
                            )
                        })
                }
            }
        },
        //注意此参数,可以实现图中那种被裁剪的效果,前提是上面的cutoutShape也有设置
        floatingActionButtonPosition = FabPosition.End,
    ) {
        //这里是主界面
        //根据底部导航选中的下标改变展示的页面
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            when (selectIndex) {
//                0 -> Text(text = "这是首页", color = Color.Red, fontSize = 30.sp)
//                1 -> Text("这是发现")
//                2 -> Text("这是我的")
//                else -> Text(
//                    "default",
//                    modifier = Modifier.fillMaxSize(),
//                    textAlign = TextAlign.Center
//                )
//            }
//        }

        AppContent(title = navTextList[selectIndex],image = imageList[selectIndex])
    }
}


@Composable
fun AppContent(
    title: String,
    image: Int
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(painter = painterResource(id = image), contentDescription = null)
            Text("当前界面是 $title", modifier = Modifier.padding(0.dp,10.dp))
        }
    }
}