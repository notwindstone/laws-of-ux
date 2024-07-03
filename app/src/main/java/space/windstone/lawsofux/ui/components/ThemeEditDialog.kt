package space.windstone.lawsofux.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import space.windstone.lawsofux.LocalThemeGetterProvider
import space.windstone.lawsofux.LocalThemeSetterProvider

@Composable
fun ThemeEditDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    val systemTheme = isSystemInDarkTheme()
    val setDarkTheme = LocalThemeSetterProvider.current
    val currentTheme = LocalThemeGetterProvider.current
    val currentThemeIndex = when (currentTheme) {
        false -> 0
        true -> 1
    }

    var selectedColorScheme by remember { mutableIntStateOf(currentThemeIndex) }
    val options = listOf(
        "Light",
        "Dark"
    )

    fun changeColorScheme(index: Int) {
        selectedColorScheme = index

        when (index) {
            0 -> setDarkTheme(false)
            1 -> setDarkTheme(true)
        }
    }

    AlertDialog(
        onDismissRequest = {
            onDismissRequest()
        },
        title = {
            Text(text = "Theme")
        },
        text = {
            SegmentedControl(
                selectedColorScheme = selectedColorScheme,
                options = options,
                action = { index ->
                    changeColorScheme(index)
                },
            )
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirmation()
            }) {
                Text("Close")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                setDarkTheme(systemTheme)
                changeColorScheme(when (systemTheme) {
                    false -> 0
                    true -> 1
                })
            }) {
                Text("Restore")
            }
        }
    )
}
