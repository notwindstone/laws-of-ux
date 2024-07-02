package space.windstone.lawsofux.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.ViewInAr
import androidx.compose.material.icons.outlined.Extension
import androidx.compose.material.icons.outlined.Psychology
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
import space.windstone.lawsofux.constants.NavigationLink

@Preview
@Composable
fun BottomBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val navigationLinks = listOf(
        NavigationLink(
            label = "Heuristic",
            selectedIcon = Icons.Filled.Psychology,
            unselectedIcon = Icons.Outlined.Psychology,
        ),
        NavigationLink(
            label = "Gestalt",
            selectedIcon = Icons.Filled.ViewInAr,
            unselectedIcon = Icons.Outlined.ViewInAr,
        ),
        NavigationLink(
            label = "Cognitive Bidas",
            selectedIcon = Icons.Filled.Extension,
            unselectedIcon = Icons.Outlined.Extension,
        ),
        NavigationLink(
            label = "Principle",
            selectedIcon = Icons.Filled.Circle,
            unselectedIcon = Icons.Outlined.Tonality,
        ),
    )

    NavigationBar {
        navigationLinks.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (selectedItem == index) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = item.label
                    )
                },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}
