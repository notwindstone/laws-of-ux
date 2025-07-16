package space.windstone.lawsofux.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import space.windstone.lawsofux.ui.pages.HistoryPage
import space.windstone.lawsofux.ui.pages.HomePage
import space.windstone.lawsofux.ui.pages.SettingsPage

data class NavigationContext(
    val route: String?,
    val triggerNavigation: (String?) -> Unit,
)

data class Route(
    val name: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val page: @Composable () -> Unit,
)

val NavigationRoutes = listOf(
    Route(
        "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home,
        page = { HomePage() },
    ),
    Route(
        "History",
        Icons.Outlined.History,
        Icons.Filled.History,
        page = { HistoryPage() },
    ),
    Route(
        "Settings",
        Icons.Outlined.Settings,
        Icons.Filled.Settings,
        page = { SettingsPage() },
    )
)