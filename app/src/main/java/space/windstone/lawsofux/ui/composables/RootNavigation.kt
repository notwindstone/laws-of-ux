package space.windstone.lawsofux.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import space.windstone.lawsofux.data.NavigationContext
import space.windstone.lawsofux.data.NavigationRoutes
import space.windstone.lawsofux.utils.contexts.LocalTriggerNavigation

@Composable
fun RootNavigation() {
    // Navigation Host
    val navController = rememberNavController()
    val currentRouteName = navController.currentBackStackEntryAsState().value?.destination?.route
    val homePage = NavigationRoutes[0].name

    CompositionLocalProvider(LocalTriggerNavigation provides NavigationContext(
        route = "asd",
        triggerNavigation = {
            if (it !== null) {
                navController.navigate(route = it)
            }
        }
    )) {
        // Consistent component shared across all navigation routes
        RootLayout {
            NavHost(navController = navController, startDestination = homePage) {
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
}