package space.windstone.lawsofux.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class Route(
    val name: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
)

val NavigationRoutes = listOf(
    Route("Home", Icons.Outlined.Home, Icons.Filled.Home),
    Route("Home", Icons.Outlined.Home, Icons.Filled.Home),
    Route("Home", Icons.Outlined.Home, Icons.Filled.Home)
)