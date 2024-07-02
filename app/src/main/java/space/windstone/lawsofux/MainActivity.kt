package space.windstone.lawsofux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import space.windstone.lawsofux.ui.components.BottomBar
import space.windstone.lawsofux.ui.components.HeaderBar
import space.windstone.lawsofux.ui.components.ScrollableContent
import space.windstone.lawsofux.ui.theme.LawsOfUXTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LawsOfUXTheme {
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