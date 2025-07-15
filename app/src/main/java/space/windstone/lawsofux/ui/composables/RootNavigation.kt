package space.windstone.lawsofux.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import space.windstone.lawsofux.data.NavigationRoutes

@Composable
fun RootNavigation() {
    // Navigation Host
    val navController = rememberNavController()
    val currentRouteName = navController.currentBackStackEntryAsState().value?.destination?.route

    // Consistent component shared across all navigation routes
    RootLayout(currentRouteName = currentRouteName, navigateTo = {
        if (it !== null) {
            navController.navigate(route = it)
        }
    }) {
        NavHost(navController = navController, startDestination = NavigationRoutes[0].name) {
            NavigationRoutes.forEach { route ->
                composable(route.name) {
                    Column {
                        route.page()
                    }
                }
            }
        }
    }
}