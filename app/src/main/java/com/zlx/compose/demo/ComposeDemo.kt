package com.zlx.compose.demo

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.zlx.compose.R
import kotlinx.coroutines.launch
import kotlin.random.Random


/**
 * 文本
 */
@Composable
fun TextSample() {
    Column {
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

/**
 * 按钮
 */
@Composable
fun ButtonSample() {
    Column {
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


@Composable
fun IConSample() {
    Column {
        Icon(imageVector = Icons.Default.DateRange, contentDescription = "date range")

        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            // 设置图标颜色
            tint = Color.Blue
        )
    }
}

@Composable
fun ImageSample() {
    Column {
        Image(imageVector = Icons.Default.DateRange, contentDescription = "date range")

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(Color.Magenta, blendMode = BlendMode.Color)
        )
    }
}


@Composable
fun SwitchSample() {
    var checked by remember {
        mutableStateOf(false)
    }
    Switch(checked = checked, onCheckedChange = { checked = it })

}


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
fun TextFieldSample() {
    var name by remember {
        mutableStateOf("")
    }
    Column(
//       modifier = Modifier.fillMaxWidth()
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
                    Color.Green
                ),
            maxLines = 5
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Account") })
    }

}


/**
 * 进度条
 */
@Composable
fun ProcessSample() {
    Column {
        CircularProgressIndicator(color = Color.Blue, strokeWidth = 10.dp)

        CircularProgressIndicator(progress = 0.6f)

        LinearProgressIndicator(color = Color.Cyan, trackColor = Color.LightGray)


    }
}

/**
 * 滑动条
 *
 * value 当前值
 * valueRange 可选值的范围，默认是0f~1f
 * steps 步频
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderSample() {
    var value by remember {
        mutableStateOf(30f)
    }
    var rangeValue by remember {
        mutableStateOf(20f..50f)
    }
    Column {
        Slider(value = value, onValueChange = { value = it }, valueRange = 0f..60f)
        Slider(value = value, onValueChange = { value = it }, valueRange = 0f..100f, steps = 10)
        RangeSlider(
            value = rangeValue,
            onValueChange = { rangeValue = it },
            valueRange = 0f..70f,
            steps = 5
        )
    }
}

/**
 * 布局容器Card
 * 提供卡片一样的样式
 */
@Composable
fun CardSample() {
    Card(
        modifier = Modifier.padding(5.dp),
        colors = CardDefaults.cardColors(Color.LightGray),
        shape = CardDefaults.outlinedShape,
        border = BorderStroke(1.dp, Color.Red),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Divider(thickness = 3.dp, color = Color.Yellow)
        Text(
            text = "This is a card",
            modifier = Modifier
                .padding(10.dp),
            color = Color.Green
        )
    }
}

/**
 * 布局容器 Box
 * 不提供任何样式
 */
@Composable
fun BoxSample() {
    Box {
        Divider(thickness = 5.dp, color = Color.Yellow)
        Box(
            Modifier
                .fillMaxSize()
                .border(width = 5.dp, color = Color.Cyan)
//                .background(Color.Cyan)
        ) {
            Text(text = "111111111", modifier = Modifier.align(Alignment.Center))
        }
        Box(
            Modifier
                .matchParentSize()
                .padding(top = 50.dp, bottom = 20.dp)
                .border(width = 5.dp, color = Color.Yellow)
//                .background(Color.Yellow)
        ) {
            Text(text = "22222222222222", modifier = Modifier.align(Alignment.Center))
        }
        Box(
            Modifier
                .matchParentSize()
                .padding(40.dp)
                .border(width = 5.dp, color = Color.Magenta)
//                .background(Color.Magenta)
        ) {
            Text(text = "3333333333333333")
        }
        Box(
            Modifier
                .align(Alignment.Center)
                .size(100.dp, 300.dp)
                .border(width = 5.dp, color = Color.Green)
//                .background(Color.Green)
        ) {
            Text(text = "44444444444", modifier = Modifier.align(Alignment.Center))
        }
        Box(
            Modifier
                .align(Alignment.TopStart)
                .size(150.dp, 150.dp)
                .border(width = 5.dp, color = Color.Red)
//                .background(Color.Red)
        ) {
            Text(text = "5555555555")
        }
        Box(
            Modifier
                .align(Alignment.BottomEnd)
                .size(150.dp, 150.dp)
                .background(Color.Transparent)
                .border(width = 5.dp, color = Color.Blue)
        ) {
            Text(text = "6666666666")
        }
    }
}

/**
 * 布局容器 列
 */
@Composable
fun ColumnSample() {
    // Create a Column with the given Modifier, vertical arrangement and horizontal alignment
    Column(
        Modifier
            // Set the size of the Column to 100dp
            .size(100.dp)
            // Set the background color of the Column to green
            .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Create a Text with the text "First Text"
        Text(text = "First Text")
        // Create a Text with the text "Second Text"
        Text(text = "Second Text")
    }
}

/**
 * 布局容器 row
 */
@Composable
fun RowSample() {
    Row(
        Modifier
            .size(700.dp, 100.dp)
            .background(Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "First", Modifier.background(Color.Yellow))
        Text(text = "Second", Modifier.background(Color.Green))
        Text(text = "Third", modifier = Modifier.background(Color.Black), color = Color.White)
    }
}

/**
 * 布局容器 LazyRow: 懒加载row 只会初始化屏幕内的row 超出屏幕外的自动销毁 节省资源
 * ListItem: 通常配合LazyRow和LazyColumn使用 自动根据父容器创建对应的row或者column 除了自带一些样式功能之外并无其他作用
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyRowSample() {
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
                    headlineText = {
                        Text(
                            text = "123",
                            Modifier
                                .background(Color.Red)
                                .size(10.dp)
                        )
                    },
                    // 主题内容上方显示的内容
                    overlineText = { Text(text = "显示在主题内容上方") },
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

@Composable
fun LazyVerticalGridSample() {
    val data = remember {
        mutableStateListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }
    Column {
        Button(
            onClick = { data.add(Random.nextInt()) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "新增数据")
        }

        // Fixed(n)设置显示几列 Adaptive(n.dp)设置单元格最小尺寸 让内容自适应
        LazyVerticalGrid(columns = GridCells.Fixed(5)) {
            items(data) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    // 这里设置字体大小sp 用dp会报错
                    Text(text = "NO.$it", fontSize = 17.sp)
                }
            }
        }
    }
}

@Composable
fun LazyHorizontalGridSample() {

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

@Composable
fun ConstraintLayoutSample() {
//    BoxWithConstraints {
//
//    }
}

@Composable
fun TabRowSample() {
    var selected by remember {
        mutableStateOf(0)
    }
    Column {
        TabRow(
            selectedTabIndex = selected,
            containerColor = Color.Gray
        ) {
            LeadingIconTab(
                selected = selected == 0,
                onClick = { selected = 0 },
                text = { Text(text = "tab0") },
                icon = { Icon(imageVector = Icons.Default.Star, contentDescription = null) },
                selectedContentColor = Color.Blue
            )
            Tab(
                selected = selected == 1,
                onClick = { selected = 1 },
                selectedContentColor = Color.Red
            ) {
                Text(text = "tab1")
            }
            Tab(
                selected = selected == 2,
                onClick = { selected = 2 },
                selectedContentColor = Color.Yellow
            ) {
                Text(text = "tab2")
            }
        }
        Text(text = "current Index: $selected", Modifier.padding(10.dp))
    }
}


/**
 * 带滚动的TabRow 其他同TabRow
 */
@Composable
fun ScrollableTabRowSample() {
    var selected by remember {
        mutableStateOf(0)
    }
    ScrollableTabRow(selectedTabIndex = selected) {

    }
}


@Composable
fun DropDownMenuSample() {
    var expanded by remember {
        mutableStateOf(false)
    }
    Column {
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

@Composable
fun SwipeToDismissSample() {
}


/**
 * Surface和Card相似 Surface更为基础 Card自带一些样式
 */
@Composable
fun SurfaceSample() {
    // shape : RectangleShape、CircleShape、RoundedCornerShape、CutCornerShape
    Surface(
        modifier = Modifier.size(300.dp, 100.dp),
        shape = RoundedCornerShape(10.dp),
        color = Color.Cyan,
        border = BorderStroke(
            1.dp,
            Color.Yellow
        ),
        shadowElevation = 10.dp,
        tonalElevation = 10.dp
    ) {
        ImageSample()
    }
}


@Composable
fun DialogSample() {
    var showDialog by remember {
        mutableStateOf(false)
    }

    Column {
        Button(onClick = { showDialog = !showDialog }) {
            Text(text = "打开弹窗")
        }
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = !showDialog }) {
                BoxSample()
            }
        }
    }

}

@Composable
fun AlertDialogSample() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    Column {
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldSample() {
//状态
//    val scaffoldState = rememberScaffoldState()
    val drawState = rememberDrawerState(initialValue = DrawerValue.Open)
    val snackbarHostState  = remember {
        SnackbarHostState()
    }

//协程的作用域
    val scope = rememberCoroutineScope()
//当前选择的NavItem
    var selectIndex by remember { mutableStateOf(0) }
    val navTextList = listOf("主页", "发现", "我的")
    val imageList = listOf(R.drawable.ab1_inversions,R.drawable.ab2_quick_yoga,R.drawable.ab5_hiit)

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


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppDrawerContent(
//    scaffoldState:,
//    scope: CoroutineScope
//) {
//
//    Box {
//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = null
//        )
//        Column(
//            modifier = Modifier.padding(15.dp)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                contentDescription = null,
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .size(65.dp)
//                    .border(BorderStroke(1.dp, Color.Gray), CircleShape)
//            )
//            Spacer(Modifier.padding(vertical = 8.dp))
//            Text(
//                text = "游客12345",
//                style = MaterialTheme.typography.bodyMedium
//            )
//        }
//    }
//
//    ListItem(
//        headlineText = {
//            Text("首页")
//        },
//        leadingContent = {
//            Icon(Icons.Filled.Home, null)
//        },
//        modifier = Modifier.clickable { }
//    )
//
//    Box(
//        modifier = Modifier.fillMaxHeight(),
//        contentAlignment = Alignment.BottomStart
//    ) {
//        TextButton(
//            onClick = { /*TODO*/ },
//            colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
//        ) {
//            Icon(Icons.Filled.Settings, null)
//            Text("设置")
//        }
//    }
//
//    // 编写逻辑
//    // 如果 drawer 已经展开了，那么点击返回键收起而不是直接退出 app
//
//    BackHandler(enabled = scaffoldState.drawerState.isOpen) {
//        scope.launch {
//            scaffoldState.drawerState.close()
//        }
//    }
//}

@Composable
fun DividerSample() {
    Divider(modifier = Modifier.padding(0.dp, 10.dp), thickness = 5.dp, color = Color.Black)
}

@Composable
fun ComposeSample() {
    val state = rememberLazyListState()
//    LazyColumn(state = state) {
//        item { TestRow("==") }
//        item { TestImageAndText(Message("Android", "jetpack Compose")) }
//        item { TextFieldSample() }
//        item { TextSample() }
//        item { ButtonSample() }
//        item { IConSample() }
//        item { ImageSample() }
//        item { SwitchSample() }
//        item { DividerSample() }
//        item { ProcessSample() }
//        item { DividerSample() }
//        item { SliderSample() }
//        item { DividerSample() }
//        item { CardSample() }
//        item { DividerSample() }
//        item { BoxSample() }
//        item { DividerSample() }
//        item { ColumnSample() }
//        item { DividerSample() }
//        item { RowSample() }
//        item { DividerSample() }
//        item { LazyRowSample() }
//        item { DividerSample() }
//        item { TabRowSample() }
//        item { DividerSample() }
//        item { DropDownMenuSample() }
//        item { DividerSample() }
//        item { SurfaceSample() }
//        item { DividerSample() }
//        item { DialogSample() }
//        item { DividerSample() }
//        item { AlertDialogSample() }
//        item { DividerSample() }
//        item { DividerSample() }
//
//    }

    // 滚动项不可以无限大 不能在LazyColumn中嵌套 否则报错
//        LazyVerticalGridSample()


//    LazyHorizontalGridSample()

    ScaffoldSample()

}