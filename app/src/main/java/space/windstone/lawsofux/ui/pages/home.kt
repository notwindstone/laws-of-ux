package space.windstone.lawsofux.ui.pages

import androidx.annotation.DisplayContext
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import space.windstone.lawsofux.R

@Composable
fun HomePage() {
    val context = LocalContext.current
    val displayHeight = context.resources.configuration.screenHeightDp

    Box {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            Modifier.heightIn(max = displayHeight.dp),
        ) {
            items(50) { _ ->
                Column {
                    Column {  }
                    Box(
                        modifier = Modifier
                            .background(Color(0xFF506485))
                            .width(IntrinsicSize.Max)
                            .height(IntrinsicSize.Max),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.aesthetic_usability_effect),
                            contentDescription = "shit",
                        )
                    }
                }
            }
        }
    }
}