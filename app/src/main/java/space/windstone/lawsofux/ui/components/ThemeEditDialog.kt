package space.windstone.lawsofux.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ThemeEditDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    var selectedColorScheme by remember { mutableIntStateOf(0) }
    val options = listOf(
        "System",
        "Light",
        "Dark"
    )

    fun changeColorScheme(index: Int) {
        selectedColorScheme = index
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
                onDismissRequest()
            }) {
                Text("Restore")
            }
        }
    )
}
