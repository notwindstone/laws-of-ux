package space.windstone.lawsofux.ui.composables

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import space.windstone.lawsofux.data.MoreMenuButton
import androidx.core.net.toUri

@Composable
fun MoreMenu() {
    val openDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val intentLawsOfUX = remember { Intent(Intent.ACTION_VIEW, "https://lawsofux.com/".toUri()) }
    val intentGithubRepo = remember { Intent(Intent.ACTION_VIEW,
        "https://github.com/notwindstone/laws-of-ux".toUri()) }
    var expanded by remember { mutableStateOf(false) }

    val buttons = listOf(
        MoreMenuButton(
            label = "Theme",
            action = {
                openDialog.value = true
                expanded = false
            },
            icon = Icons.Outlined.Home,
        ),
        MoreMenuButton(
            label = "Github",
            action = {
                context.startActivity(intentGithubRepo)
            },
            icon = Icons.Outlined.Home,
        ),
        MoreMenuButton(
            label = "Laws of UX",
            action = {
                context.startActivity(intentLawsOfUX)
            },
            icon = Icons.Outlined.Home,
        ),
    )

    Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.TopStart)) {
        IconButton(
            onClick = { expanded = true }
        ) {
            Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            buttons.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(item.label)
                    },
                    onClick = item.action,
                    leadingIcon = {
                        Icon(
                            item.icon,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }
        }
    }
}