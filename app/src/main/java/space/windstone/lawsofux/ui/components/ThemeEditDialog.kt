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
        title = { Text(text = "Title") },
        text = { Text(text = "Turned on by default") },
        confirmButton = {
            TextButton(onClick = {
                onConfirmation()
            }) {
                Text("Confirm")
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
