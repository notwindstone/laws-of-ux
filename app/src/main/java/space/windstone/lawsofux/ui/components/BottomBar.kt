package space.windstone.lawsofux.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BorderStyle
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Square
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tonality
import androidx.compose.material.icons.filled.ViewInAr
import androidx.compose.material.icons.outlined.BorderStyle
import androidx.compose.material.icons.outlined.CheckBoxOutlineBlank
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Extension
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Psychology
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material.icons.outlined.Tonality
import androidx.compose.material.icons.outlined.ViewInAr
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun BottomBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(
        "Heuristic",
        "Gestalt",
        "Cognitive Bias",
        "Principle"
    )
    val selectedIcons = listOf(
        Icons.Filled.Psychology,
        Icons.Filled.ViewInAr,
        Icons.Filled.Extension,
        Icons.Filled.Circle
    )
    val unselectedIcons = listOf(
        Icons.Outlined.Psychology,
        Icons.Outlined.ViewInAr,
        Icons.Outlined.Extension,
        Icons.Outlined.Tonality
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) {
                            selectedIcons[index]
                        } else {
                            unselectedIcons[index]
                        },
                        contentDescription = item
                    )
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }

}