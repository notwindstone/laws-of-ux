package space.windstone.lawsofux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import space.windstone.lawsofux.ui.components.BottomBar
import space.windstone.lawsofux.ui.components.HeaderBar
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
                        LazyColumn(
                            contentPadding = innerPadding,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            val list = (0..75).map { it.toString() }
                            items(count = list.size) {
                                Text(
                                    text = list[it],
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                                )
                            }
                        }
                    }
                )

            }
        }
    }
}

@Composable
fun Layout(name: String, modifier: Modifier = Modifier) {
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state)
    ) {
        Text(
            text = "Hello, $name!",
            modifier = modifier
        )
        Text(
            text = "Hello, $name!",
            modifier = modifier
        )
        Text(
            text = "Hello, $name!",
            modifier = modifier
        )
        Text(
            text = "Hello, $name!",
            modifier = modifier
        )
        Text(
            text = "Hello, $name!",
            modifier = modifier
        )
    }
}