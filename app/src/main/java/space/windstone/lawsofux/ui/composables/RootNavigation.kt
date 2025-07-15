package space.windstone.lawsofux.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    val currentRouteName = navController.currentBackStackEntryAsState().value?.destination?.route

    RootLayout(currentRouteName = currentRouteName, navigateTo = {
        if (it !== null) {
            navController.navigate(route = it)
        }
    }) {
        NavHost(navController = navController, startDestination = "Home") {
            composable("Home") {
                Column {
                    repeat(50) { Text("this is home page") }
                }
            }
            composable("FriendsList") {
                Text("Not Hello")
            }
        }
    }
}