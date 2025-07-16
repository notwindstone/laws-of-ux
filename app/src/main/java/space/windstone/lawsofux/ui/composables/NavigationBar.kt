package space.windstone.lawsofux.ui.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import space.windstone.lawsofux.data.NavigationRoutes
import space.windstone.lawsofux.utils.contexts.LocalTriggerNavigation

@Composable
fun NavigationBar() {
    val navigateTo = LocalTriggerNavigation.current.triggerNavigation
    val currentRoute = LocalTriggerNavigation.current.route

    NavigationBar {
        NavigationRoutes.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (currentRoute === item.name) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = item.name,
                    )
                },
                label = { Text(item.name) },
                selected = currentRoute === item.name,
                onClick = {
                    navigateTo(item.name)
                },
            )
        }
    }
}