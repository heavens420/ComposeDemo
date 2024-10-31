package com.zlx.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zlx.compose.ui.components.RowItem
import com.zlx.compose.ui.theme.ComposeDemoTheme
import com.zlx.compose.ui.screens.AlertDialogScreen
import com.zlx.compose.ui.screens.ButtonScreen
import com.zlx.compose.ui.screens.ColumnScreen
import com.zlx.compose.ui.screens.DialogScreen
import com.zlx.compose.ui.screens.DividerScreen
import com.zlx.compose.ui.screens.DropDownMenuScreen
import com.zlx.compose.ui.screens.IconScreen
import com.zlx.compose.ui.screens.ImageScreen
import com.zlx.compose.ui.screens.LazyColumnScreen
import com.zlx.compose.ui.screens.LazyHorizontalGridScreen
import com.zlx.compose.ui.screens.LazyRowScreen
import com.zlx.compose.ui.screens.TextScreen

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
fun HomeScreen(onColumnClick: (String) -> Unit) {
//    val list = List(10) { "$it" }
//    val viewModelList = ViewModelData.list
    val viewModelList = viewData
    LazyColumn(Modifier.padding(vertical = 4.dp)) {
        items(items = viewModelList) { item ->
            RowItem(item, onColumnClick)
        }
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
//        MyApp()
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "home") {
            composable(route = "home") {
                HomeScreen { route ->
                    navController.navigate(route)
                }
            }
            composable(route = TextData.route){
                TextScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = AlertDialogData.route){
                AlertDialogScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = ButtonData.route){
                ButtonScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = ColumnData.route){
                ColumnScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = DialogData.route){
                DialogScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = DividerData.route){
                DividerScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = DropDownMenuData.route){
                DropDownMenuScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = IconData.route){
                IconScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = ImageData.route){
                ImageScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = LazyColumnData.route){
                LazyColumnScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = LazyHorizontalGridData.route){
                LazyHorizontalGridScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = LazyRowData.route){
                LazyRowScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
            composable(route = LazyRowData.route){
                LazyRowScreen(navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }
        }
    }
}
