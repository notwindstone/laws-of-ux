package space.windstone.lawsofux.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material.icons.outlined.Palette
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Github
import space.windstone.lawsofux.constants.MoreMenuButton

@Preview
@Composable
fun MoreMenu() {
    val openDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val intentLawsOfUX = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://lawsofux.com/")) }
    val intentGithubRepo = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/notwindstone/laws-of-ux")) }
    var expanded by remember { mutableStateOf(false) }

    val buttons = listOf(
        MoreMenuButton(
            label = "Theme",
            action = {
                openDialog.value = true
                expanded = false
            },
            icon = Icons.Outlined.Palette,
        ),
        MoreMenuButton(
            label = "Github",
            action = {
                context.startActivity(intentGithubRepo)
            },
            icon = FontAwesomeIcons.Brands.Github,
        ),
        MoreMenuButton(
            label = "Laws of UX",
            action = {
                context.startActivity(intentLawsOfUX)
            },
            icon = Icons.Outlined.Link,
        ),
    )

    Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.TopStart)) {
        when {
            openDialog.value -> {
                ThemeEditDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    onConfirmation = {
                        openDialog.value = false
                    },
                )
            }
        }
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
