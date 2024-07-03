package space.windstone.lawsofux.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ThemeEditDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = {
            onDismissRequest()
        },
        title = {
            Text(text = "Theme")
        },
        text = {
            SegmentedControl()
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirmation()
            }) {
                Text("Apply")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismissRequest()
            }) {
                Text("Dismiss")
            }
        }
    )
}
