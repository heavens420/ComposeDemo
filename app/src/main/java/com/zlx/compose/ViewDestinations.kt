package com.zlx.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.ui.graphics.vector.ImageVector

interface ViewDestinations {
    val icon: ImageVector
    val route: String
    val name: String
    val description: String
}

object TextData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "TextData"
    override val name: String = "Text use demo"
    override val description: String =
        "This is a demo about component Text, you can click this item to see specific information"
}

object AlertDialogData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "AlertDialogData"
    override val name: String = "AlertDialog use demo"
    override val description: String =
        "This is a demo about component AlertDialog, you can click this item to see specific information"
}

object ButtonData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "ButtonData"
    override val name: String = "Button use demo"
    override val description: String =
        "This is a demo about component Button, you can click this item to see specific information"
}

object CardData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "CardData"
    override val name: String = "Card use demo"
    override val description: String =
        "This is a demo about component Card, you can click this item to see specific information"
}

object ColumnData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "ColumnData"
    override val name: String = "Column use demo"
    override val description: String =
        "This is a demo about component Column, you can click this item to see specific information"
}

object DialogData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "DialogData"
    override val name: String = "Dialog use demo"
    override val description: String =
        "This is a demo about component Dialog, you can click this item to see specific information"
}

object DividerData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "DividerData"
    override val name: String = "Divider use demo"
    override val description: String =
        "This is a demo about component Divider, you can click this item to see specific information"
}

object IconData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "IconData"
    override val name: String = "Icon use demo"
    override val description: String =
        "This is a demo about component Icon, you can click this item to see specific information"
}

object DropDownMenuData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "DropDownMenuData"
    override val name: String = "DropDownMenu use demo"
    override val description: String =
        "This is a demo about component DropDownMenu, you can click this item to see specific information"
}

object ImageData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "ImageData"
    override val name: String = "Image use demo"
    override val description: String =
        "This is a demo about component Image, you can click this item to see specific information"
}

object LazyColumnData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "LazyColumnData"
    override val name: String = "LazyColumn use demo"
    override val description: String =
        "This is a demo about component LazyColumn, you can click this item to see specific information"
}

object LazyHorizontalGridData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "LazyHorizontalGridData"
    override val name: String = "LazyHorizontalGrid use demo"
    override val description: String =
        "This is a demo about component LazyHorizontalGrid, you can click this item to see specific information"
}

object LazyRowData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "LazyRowData"
    override val name: String = "LazyRow use demo"
    override val description: String =
        "This is a demo about component LazyRow, you can click this item to see specific information"
}
object LazyVerticalGridData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "LazyVerticalGridData"
    override val name: String = "LazyVerticalGrid use demo"
    override val description: String =
        "This is a demo about component LazyVerticalGrid, you can click this item to see specific information"
}

object NavigationData : ViewDestinations {
    override val icon: ImageVector = Icons.Filled.Create
    override val route: String = "NavigationData"
    override val name: String = "Navigation use demo"
    override val description: String =
        "This is a demo about component Navigation, you can click this item to see specific information"
}


val viewData = listOf(
    TextData,
    AlertDialogData,
    ButtonData,
    CardData,
    ColumnData,
    DialogData,
    DividerData,
    IconData,
    DropDownMenuData,
    ImageData,
    LazyColumnData,
    LazyHorizontalGridData,
    LazyRowData

)
