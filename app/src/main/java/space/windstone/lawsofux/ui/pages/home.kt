package space.windstone.lawsofux.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import space.windstone.lawsofux.R

@Composable
fun HomePage() {
    val context = LocalContext.current
    val displayHeight = context.resources.configuration.screenHeightDp

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        Modifier.heightIn(max = displayHeight.dp),
        contentPadding = PaddingValues(
            horizontal = 8.dp,
            vertical = 8.dp
        ),
    ) {
        items(20) { _ ->
            Box(Modifier.padding(8.dp)) {
                Column(
                    Modifier
                        .background(
                            color = MaterialTheme.colorScheme.surfaceBright,
                            shape = RoundedCornerShape(16.dp),
                        )
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color(0xFF506485), shape = RoundedCornerShape(16.dp))
                            .fillMaxWidth()
                            .height(144.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.aesthetic_usability_effect),
                            contentDescription = "shit",
                        )
                    }
                    Column(
                        Modifier.padding(
                            top = 24.dp,
                            bottom = 16.dp,
                            start = 16.dp,
                            end = 16.dp,
                        ),
                    ) {
                        Text(
                            fontSize = 20.sp,
                            text = "Aesthetic-Usability Effect",
                        )
                        Text(
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.outline,
                            text = "Users often perceive aesthetically pleasing design as design that’s more usable.",
                        )
                    }
                }
            }
        }
    }
}