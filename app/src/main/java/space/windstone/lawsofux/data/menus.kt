package space.windstone.lawsofux.data

import androidx.compose.ui.graphics.vector.ImageVector

data class MoreMenuButton(
    val label: String,
    val action: () -> Unit,
    val icon: ImageVector,
)