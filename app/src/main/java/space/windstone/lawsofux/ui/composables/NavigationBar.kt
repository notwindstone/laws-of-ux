package space.windstone.lawsofux.ui.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import space.windstone.lawsofux.data.NavigationRoutes

@Composable
fun NavigationBar(
    navigateTo: (String?) -> Unit,
) {
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar {
        NavigationRoutes.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = item.name,
                    )
                },
                label = { Text(item.name) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navigateTo(item.name)
                },
            )
        }
    }
}