package space.windstone.lawsofux.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import space.windstone.lawsofux.utils.contexts.LocalTriggerNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootLayout(
    children: @Composable () -> Unit,
) {
    val scrollingState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val currentRouteName = LocalTriggerNavigation.current.route

    Scaffold(
        topBar = {
            if (currentRouteName !== null) {
                Header(pinned = scrollBehavior, title = currentRouteName)
            }
        },
        bottomBar = {
            NavigationBar()
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .verticalScroll(scrollingState),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            children()
        }
    }
}