package space.windstone.lawsofux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import space.windstone.lawsofux.ui.components.BottomBar
import space.windstone.lawsofux.ui.components.HeaderBar
import space.windstone.lawsofux.ui.components.ScrollableContent
import space.windstone.lawsofux.ui.theme.LawsOfUXTheme

val LocalThemeSetterProvider = compositionLocalOf<(Boolean) -> Unit> { error("Something went wrong...") }
val LocalThemeGetterProvider = compositionLocalOf<Boolean> { error("Something went wrong...") }

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemTheme = isSystemInDarkTheme()
            val (darkTheme, setDarkTheme) = remember { mutableStateOf(systemTheme) }

            CompositionLocalProvider(
                LocalThemeSetterProvider provides setDarkTheme,
                LocalThemeGetterProvider provides darkTheme,
            ) {
                LawsOfUXTheme(darkTheme = darkTheme) {
                    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

                    Scaffold(
                        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                        topBar = {
                            HeaderBar(scrollBehavior = scrollBehavior)
                        },
                        bottomBar = {
                            BottomBar()
                        },
                        content = { innerPadding ->
                            ScrollableContent(innerPadding)
                        }
                    )
                }
            }
        }
    }
}