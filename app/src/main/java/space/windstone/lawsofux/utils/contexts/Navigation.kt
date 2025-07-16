package space.windstone.lawsofux.utils.contexts

import androidx.compose.runtime.compositionLocalOf
import space.windstone.lawsofux.data.NavigationContext

val LocalTriggerNavigation = compositionLocalOf {
    // route
    NavigationContext(route = "")
    // triggerNavigation
    { }
}