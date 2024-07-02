package space.windstone.lawsofux.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = { Text("Laws of UX", maxLines = 1, overflow = TextOverflow.Ellipsis) },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                MoreMenu()
            }
        },
        scrollBehavior = scrollBehavior
    )
}
