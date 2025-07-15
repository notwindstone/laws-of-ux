package space.windstone.lawsofux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import space.windstone.lawsofux.ui.composables.RootNavigation
import space.windstone.lawsofux.ui.theme.LawsOfUXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LawsOfUXTheme {
                RootNavigation()
            }
        }
    }
}